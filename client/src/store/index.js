import Vuex from 'vuex'
import Vue from 'vue'


Vue.use(Vuex)


  const store =  new Vuex.Store({
    state:{
        meal: {},
        order: {},
        customer:{},
        survivor: {},
        contaminant: {},
        user: { name: 'John Doe', email: 'fake@email.com', username: 'jd123'},
        serviceProvider: {},
        city: ''
    },
    getters:{
        getServiceProvider: state => {
            return state.serviceProvider
        },
        getCity: state => {
            return state.city
        },
        getMeal: state => {
            return state.meal
        },
        getOrder: state => {
            return state.order
        },
        getCustomer: state => {
            return state.customer
        },
        getSurvivor: state => {
            return state.survivor
        },
        getContamination: state =>{
            return state.contaminant
        }
    },
    mutations: {
        saveServiceProvider (state, payload) {
            state.serviceProvider = payload
          },
        saveCity (state, payload) {
            state.city = payload
        },
        saveMeal(state, payload) {
            state.meal = payload
        },
        saveOrder(state, payload) {
            state.order = payload
        },
        saveCustomer(state, payload) {
            state.customer = payload
        },
        saveContamination(state, payload) {
            state.contaminant = payload
        },
        saveSurvivor(state, payload) {
            state.survivor = payload
        }
    },
    actions:{}
    
  })

  export default store
