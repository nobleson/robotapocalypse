<template>
  <div>
        <div class="container">
             <div class="row">
                <div class="card-columns d-flex justify-content-center service-card-deck">
                            <b-card
                                title="Report Contamination"
                                style="max-width: 25rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                            <b-card-text>
                        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
                            <b-form-group
                                id="input-group-1"
                                label="Your Survivor ID:"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.reportedSurvivor"
                                type="number"
                                placeholder="Enter ID"
                                required
                                ></b-form-input>
                            </b-form-group>

                            <b-form-group id="input-group-2" label="Contaminated Survivor:" label-for="input-2">
                            
                                <b-form-input
                                id="input-2"
                                v-model="form.inffectedSurvivor"
                                placeholder="Enter ID of Contaminant"
                                type="number"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-button type="submit" variant="primary" :disabled="isDisabled">Submit Report   
                              <b-spinner variant="warning" label="Spinning" v-if="isDisabled"></b-spinner>
                            </b-button>
                            <b-button type="reset" variant="danger">Reset</b-button>
                            </b-form>
                            </b-card-text>
                              <router-link to="/" title="Home page">
                                    <h5>Back home</h5>
                                </router-link>
                            </b-card>

                </div>
                  {{survivors}}           
            </div>
        </div>
  </div>
</template>

<script>
import api from '../plugins/SurvivorAPI';
import {mapGetters, mapActions,mapState,mapMutations } from 'vuex'

export default {
  name: "report",
    components: {},
    data() {
        return {
            isDisabled : false,
            survivorsList: [],
            isSurvivorSelected: false,
            form: {
            reportedSurvivor: '',
            inffectedSurvivor: ''
            },
            show: true
        }
    },
    mounted(){
        this.loadSurvivors()
    },
    computed: {
        survivors(){
            if(this.survivorsList)
            return this.survivorsList
        }
    },
    methods: {

        loadSurvivors(){
            api.getAll('/survivors')  
            .then(response => { 
                if(response.data){
                    this.survivorsList =  response.data
                }
            })  
            .catch(error => {  
                console.log(error)  
            })  
        },
        async getSurvivor(){
           try{
               return await api.getById('/survivor/'+this.form.inffectedSurvivor)  
           }catch(error){
               console.log(error)
                alert("Oops!, Survivor not found with this ID")
           }
        },
     async onSubmit(event) {
        event.preventDefault()
        this.isDisabled = !this.isDisabled
        let survivor = await this.getSurvivor()
        if(survivor){
            let survivorStatus = Number(survivor.data.survivorStatus)
            if(survivorStatus < 3){
                survivorStatus++
                survivor.data.survivorStatus = survivorStatus
                api.update('/survivor/'+this.form.inffectedSurvivor, survivor.data).then( response => {
                if(response.data){
                    alert('Contamination report submitted')
                    this.loadSurvivors()
                    this.isDisabled = !this.isDisabled
                }
                }).catch(error => {
                    console.log(error)
                    alert("Error occured, report not submitted")
                    this.isDisabled = !this.isDisabled
                })
            }else{
             this.isDisabled = !this.isDisabled
              alert("Oops!, Survivor is already infected")
            }
        }else{
        this.isDisabled = !this.isDisabled
          alert("Oops!, Survivor not found with this ID")
        }
        //this.saveContamination(this.form)
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.reportedSurvivor = '',
        this.form.inffectedSurvivor = ''
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    } 

};
</script>
