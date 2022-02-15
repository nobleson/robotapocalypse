<template>
  <div>
        <div class="container">
             <div class="row">
                <div class="card-columns d-flex justify-content-center service-card-deck">
                            <b-card
                                title="Register Survivors"
                                style="max-width: 25rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                            <b-card-text>
                        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
                            <b-form-group
                                id="input-group-1"
                                label="First Name:"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.firstName"
                                type="text"
                                placeholder="Enter first name"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group
                                id="input-group-1"
                                label="Last Name:"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.lastName"
                                type="text"
                                placeholder="Enter last name"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group
                                id="input-group-1"
                                label="Age:"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.age"
                                type="number"
                                placeholder="Enter age"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group id="input-group-3" label="Gender:" label-for="input-3">
                                <b-form-select
                                id="input-3"
                                v-model="form.gender"
                                :options="gender"
                                required
                                ></b-form-select>
                            </b-form-group>
                            <b-form-group
                                id="input-group-1"
                                label="Location Latitude:"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.lastLocationLatitude"
                                type="number"
                                placeholder="Enter Latitude"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group
                                id="input-group-1"
                                label="Location Longitude:"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.lastLocationLongitude"
                                type="number"
                                placeholder="Enter Longitude"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group id="input-group-3" label="Resoources:" label-for="input-3">
                                <b-form-select v-model="form.resources" :options="options" multiple :select-size="4" required></b-form-select>
                            </b-form-group>

                            <b-button type="submit" variant="primary" :disabled="isDisabled">Register   
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
                firstName: '',
                lastName: '',
                age: '',
                survivorStatus: 0,
                lastLocationLatitude: '',
                lastLocationLongitude: '',
                gender: null,
                resources: []
            },
            options: [
            { value: null, text: 'Select Resources', disabled: true},
            { value: 'Food', text: 'Food' },
            { value: 'Water', text: 'Water' },
            { value: 'Medication', text: 'Medication' },
            { value: 'Ammunition', text: 'Ammunition'}
            ],
            gender: [{ text: 'Select Gender', value: null }, 'Male', 'Female'],
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
        api.createNew('/survivor', this.form).then( response => {
            if(response.data){
                this.loadSurvivors()
                alert('Survivor registered')
                this.isDisabled = !this.isDisabled
            }
        }).catch(error => {
            console.log(error)
            alert("Error occured, could not register survivor")
            this.isDisabled = !this.isDisabled
        })

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
