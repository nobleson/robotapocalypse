<template>
  <div>
        <div class="container">
             <div class="row">
                <div class="card-columns d-flex justify-content-center service-card-deck">
                            <b-card
                                title="Update Last Location"
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
                                v-model="form.id"
                                type="number"
                                placeholder="Enter ID"
                                required
                                ></b-form-input>
                            </b-form-group>

                            <b-form-group id="input-group-2" label="Latitude:" label-for="input-2">
                                <b-form-input
                                id="input-2"
                                v-model="form.lastLocationLatitude"
                                placeholder="Enter latitude"
                                required
                                ></b-form-input>
                            </b-form-group>
                            
                            <b-form-group id="input-group-2" label="Longitude:" label-for="input-2">
                                <b-form-input
                                id="input-2"
                                v-model="form.lastLocationLongitude"
                                placeholder="Enter longitude"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-button type="submit" variant="primary" :disabled="isDisabled">Update Location   
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
  name: "location",
    components: {},
    data() {
        return {
            isDisabled : false,
            survivorsList: [],
            survivor: {},
            form: {
            id: '',
            lastLocationLatitude: '',
            lastLocationLongitude: ''
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
        async getSurvivor(){
           return await api.getById('/survivor/'+this.form.id)  
        },
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

      async onSubmit(event) {
        event.preventDefault()
        this.isDisabled = !this.isDisabled
        let survivor = await this.getSurvivor() 
        if(survivor.data){
            survivor.data.lastLocationLatitude = this.form.lastLocationLatitude
            survivor.data.lastLocationLongitude = this.form.lastLocationLongitude
            api.update('/survivor/'+this.form.id, survivor.data).then( response => {
                if(response.data){
                    this.loadSurvivors()
                    alert('survivor last location updated')
                    this.isDisabled = !this.isDisabled
                }
            }).catch(error => {
                console.log(error)
                alert("Error occured, location not updated")
                this.isDisabled = !this.isDisabled
            })
        }else{
            alert("Oops!, Survivor not found with this ID")
        }

        //this.saveContamination(this.form)
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.id = ''
        this.form.lastLocationLatitude = ''
        this.form.lastLocationLongitude = ''
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    } 

};
</script>
