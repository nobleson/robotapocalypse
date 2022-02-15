import axios from 'axios'    
const $api_url = 'https://cors-anywhere.herokuapp.com/https://robotstakeover20210903110417.azurewebsites.net';
const instance = axios.create({  
  baseURL: $api_url,  
});  
  
export default {  
  async execute(method, resource, data, config) {  
        //let accessToken = await Vue.prototype.$auth.getAccessToken()  
        return instance({  
          method:method,  
          url: resource,  
          data,  
          headers: {  
            //    Authorization: `Bearer ${accessToken}`  
          },  
          ...config  
        })  
  },  
  getAll: (url) => instance.get(url, {  
    transformResponse: [function (data) {  
       //console.log(JSON.stringify(data)) 
      return  JSON.parse(data);  
    }]  
  }),  



}