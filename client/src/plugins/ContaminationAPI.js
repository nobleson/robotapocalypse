import axios from 'axios'    
const $api_url = 'http://localhost:8080';  

const instance = axios.create({  
  baseURL: $api_url,  
});  
  
export default {  
  
  // (R)ead  
  getAll: (url) => instance.get(url, {  
    transformResponse: [function (data) {  
      // console.log(JSON.stringify(data)) 
      return data? JSON.parse(data)._embedded.contaminationList : data;  
    }]  
  }),  
  createNew: (url, payload) => {  
    return instance.post(url, payload)  
},  
getById: (url) => instance.get(url, {  
  transformResponse: [function (data) {  
      return JSON.parse(data)
      //return data? JSON.parse(data)._embedded.serviceProviderList : data;  
  }]  
  }),  
  update: (url, payload) => {  
    return instance.put(url, payload)  
   },  

}