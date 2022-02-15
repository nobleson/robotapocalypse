<template>
<div class="section-shaped my-0">
            <div class="shape shape-style-1 shape-primary">
            <span class="span-150"></span>
            <span class="span-50"></span>
            <span class="span-50"></span>
            <span class="span-75"></span>
            <span class="span-100"></span>
            <span class="span-75"></span>
            <span class="span-50"></span>
            <span class="span-100"></span>
            <span class="span-50"></span>
            <span class="span-100"></span>
        </div>
       <div class="container shape-container  align-items-center">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-7 text-center " style="padding-bottom: 20px">
                             <router-link to="/register" title="Report page">
                                    <b-button block  size="lg" variant="primary">Register Survivor</b-button>
                                </router-link>
                    </div>
                </div>
        </div>
        <div class="container">
                         <div class="row">
                         <b-card-group deck class="card-columns d-flex justify-content-center service-card-deck">
                            <b-card
                                title="Infected Survivors"
                                style="max-width: 20rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                Percentage
                                </b-card-text>
                                <div class="text-center">
                                <b-button variant="danger">
                                  <h5><b-badge variant="light">{{infectedPercentage}} <span class="sr-only">unread messages</span></b-badge>
                                    %</h5>
                                </b-button>
                                </div>
                            </b-card>
                            <b-card
                                title="Non-Infected Survivors"
                                tag="article"
                                style="max-width: 20rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                Percentage
                                </b-card-text>
                                <div class="text-center">
                                <b-button variant="success">
                                 <h5><b-badge variant="light">{{nonInfectedPercentage}} <span class="sr-only">unread messages</span></b-badge>
                                    %</h5>
                                </b-button>
                                </div>
                            </b-card>
                </b-card-group>
            </div>
             <div class="row">
                <b-card-group deck class="card-columns d-flex justify-content-center service-card-deck">
                             <b-card
                                title="Infected Survivors"
                                style="max-width: 20rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                <div>
                                    <vue-good-table
                                    :columns="survivorColumns"
                                    :rows="infections"/>
                                </div>
                                </b-card-text>
                            </b-card>
                            <b-card
                                title="Non Infected Survivors"
                                style="max-width: 20rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                <b-card-text>
                                <div>
                                    <vue-good-table
                                    :columns="survivorColumns"
                                    :rows="nonInfections"/>
                                </div>
                                </b-card-text>
                                </b-card-text>
                            </b-card>
                </b-card-group>
            </div>
             <div class="row">
                <b-card-group deck class="card-columns d-flex justify-content-center service-card-deck">
                            <b-card
                                title="Robots"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                 <b-card-text>
                                <div>
                                    <vue-good-table
                                    :columns="robotColumns"
                                    :rows="rows"/>
                                </div>
                                </b-card-text>
                                </b-card-text>
                            </b-card>
                </b-card-group>
            </div>

        </div>
</div>
</template>
<script>
import api from '../plugins/SurvivorAPI';
import robotAPI from '../plugins/RobotAPI';
// add to component
export default {
  name: "location",
    components: {    },
    data() {
        return {
            isDisabled : false,
            survivorsList: [],
            infections: [],
            nonInfections: [],
            infectedSurvivors: 0,
            nonInfectedSurvivors: 0,
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
            robotColumns: [
                {
                label: 'Model',
                field: 'model',
                },
                {
                label: 'Serial Number',
                field: 'serialNumber',
                type: 'text',
                },
                {
                label: 'Manufactured Date',
                field: 'manufacturedDate',
                type: 'text',
                },   
                {
                label: 'Robot Category',
                field: 'category',
                type: 'text',
                },         
            ],
            survivorColumns: [
                    {
                    label: 'ID',
                    field: 'id',
                    type: 'number'
                    },
                    {
                    label: 'First Name',
                    field: 'firstName',
                    type: 'text',
                    },
                    {
                    label: 'Last Name',
                    field: 'lastName',
                    type: 'text',
                    },
                ],
            show: true,
            rows: [{"model":"0QJQ2","serialNumber":"O1MS3GSIUVSC48F","manufacturedDate":"2022-03-01T12:07:25.5004318+00:00","category":"Land"},{"model":"2ASTN","serialNumber":"4NX21V1WY11ZB99","manufacturedDate":"2022-02-20T12:07:25.5004214+00:00","category":"Land"},{"model":"2XTVB","serialNumber":"RSG5OMFZ53CBRJF","manufacturedDate":"2022-04-02T12:07:25.5004758+00:00","category":"Land"},{"model":"3XDLV","serialNumber":"OOWU4SZZEGRS0BX","manufacturedDate":"2022-03-14T12:07:25.5004459+00:00","category":"Flying"},{"model":"4ZPZK","serialNumber":"M340LZYRCQHT8W5","manufacturedDate":"2022-03-21T12:07:25.5004627+00:00","category":"Land"},{"model":"50YOR","serialNumber":"7LGK8HLU722LALL","manufacturedDate":"2022-02-26T12:07:25.500428+00:00","category":"Land"},{"model":"8K6VH","serialNumber":"OZPDF37UBR9O4LT","manufacturedDate":"2022-03-29T12:07:25.5004714+00:00","category":"Flying"},{"model":"9N9I1","serialNumber":"IPOG2JY51WQUIP2","manufacturedDate":"2022-03-06T12:07:25.5004371+00:00","category":"Land"},{"model":"9Q5ZR","serialNumber":"DJEKD5OQIW5Y1Q3","manufacturedDate":"2022-03-16T12:07:25.5004481+00:00","category":"Land"},{"model":"APEA7","serialNumber":"I52S3STTOD4APL7","manufacturedDate":"2022-03-20T12:07:25.5004524+00:00","category":"Flying"},{"model":"CGB5X","serialNumber":"WSXI87JKN7WIEKA","manufacturedDate":"2022-02-21T12:07:25.5004225+00:00","category":"Flying"},{"model":"D0BSK","serialNumber":"CM3447GZ46SBATS","manufacturedDate":"2022-02-16T12:07:25.5004054+00:00","category":"Land"},{"model":"D5HMB","serialNumber":"POSLW1M0DV78ED3","manufacturedDate":"2022-03-12T12:07:25.5004438+00:00","category":"Land"},{"model":"DNYX0","serialNumber":"5HS6NZ8TU6VI29B","manufacturedDate":"2022-03-27T12:07:25.5004692+00:00","category":"Land"},{"model":"DTJAM","serialNumber":"IQ1TMXVJUXXHA3K","manufacturedDate":"2022-02-24T12:07:25.5004258+00:00","category":"Flying"},{"model":"DVMRK","serialNumber":"NDQT929IQUNER68","manufacturedDate":"2022-03-13T12:07:25.5004448+00:00","category":"Land"},{"model":"EO4LT","serialNumber":"DHP8O1BJNCYQ1VR","manufacturedDate":"2022-04-01T12:07:25.5004747+00:00","category":"Flying"},{"model":"EZJBM","serialNumber":"Y0N8FBCRNBJSDH1","manufacturedDate":"2022-03-02T12:07:25.5004329+00:00","category":"Flying"},{"model":"FW81Y","serialNumber":"9ISU1HCVGKAGIDD","manufacturedDate":"2022-03-03T12:07:25.5004339+00:00","category":"Land"},{"model":"I6K8T","serialNumber":"DFCOTH941JUTR14","manufacturedDate":"2022-03-09T12:07:25.5004405+00:00","category":"Land"},{"model":"IM37O","serialNumber":"HFO7N1EZF1Q427K","manufacturedDate":"2022-03-11T12:07:25.5004426+00:00","category":"Flying"},{"model":"JIXMI","serialNumber":"Y54RUH8QF7R5JJB","manufacturedDate":"2022-04-03T12:07:25.5004769+00:00","category":"Land"},{"model":"JOVZG","serialNumber":"H67ZYPL8ZED21DD","manufacturedDate":"2022-03-25T12:07:25.500467+00:00","category":"Land"},{"model":"K2CRA","serialNumber":"JAK4CS2VLQW2G1Y","manufacturedDate":"2022-03-10T12:07:25.5004416+00:00","category":"Land"},{"model":"KEDNA","serialNumber":"BQVEZ9Q4EY5BI40","manufacturedDate":"2022-03-17T12:07:25.5004492+00:00","category":"Flying"},{"model":"KV3FD","serialNumber":"DH564F2TIP8V311","manufacturedDate":"2022-02-27T12:07:25.5004291+00:00","category":"Flying"},{"model":"M0P33","serialNumber":"LRI0FTU08VPMOIR","manufacturedDate":"2022-02-23T12:07:25.5004246+00:00","category":"Land"},{"model":"M78L4","serialNumber":"2EJSH3RIE9QSB56","manufacturedDate":"2022-03-15T12:07:25.500447+00:00","category":"Land"},{"model":"NE83L","serialNumber":"GL78COIYI9E9SC4","manufacturedDate":"2022-03-28T12:07:25.5004703+00:00","category":"Land"},{"model":"NW4XW","serialNumber":"GT8OHWY3T3V8W50","manufacturedDate":"2022-02-22T12:07:25.5004236+00:00","category":"Land"},{"model":"NWOYQ","serialNumber":"4GTZXTSK9E4FL09","manufacturedDate":"2022-02-15T12:07:25.5003937+00:00","category":"Flying"},{"model":"OBBGD","serialNumber":"3BR76KC3POC5YQA","manufacturedDate":"2022-03-23T12:07:25.5004649+00:00","category":"Flying"},{"model":"QH3G7","serialNumber":"9RLDADK9DD1IVAU","manufacturedDate":"2022-03-05T12:07:25.5004361+00:00","category":"Flying"},{"model":"QKIJC","serialNumber":"ALNLFHFIAQR0XYP","manufacturedDate":"2022-03-24T12:07:25.500466+00:00","category":"Land"},{"model":"R532I","serialNumber":"RXW1A0EHTJY0BX0","manufacturedDate":"2022-03-31T12:07:25.5004737+00:00","category":"Land"},{"model":"S131J","serialNumber":"K5TVRJZNE1K9OZV","manufacturedDate":"2022-03-22T12:07:25.5004638+00:00","category":"Land"},{"model":"S99PL","serialNumber":"OAARE20UCW4NSYQ","manufacturedDate":"2022-03-18T12:07:25.5004503+00:00","category":"Land"},{"model":"SNZ40","serialNumber":"M3QDW2F2IKXC2JZ","manufacturedDate":"2022-02-18T12:07:25.500408+00:00","category":"Flying"},{"model":"SXF2Z","serialNumber":"F3286MIAA1CZTD5","manufacturedDate":"2022-03-26T12:07:25.5004681+00:00","category":"Flying"},{"model":"TCFK1","serialNumber":"OPHQWH9FH7KVQ9C","manufacturedDate":"2022-03-08T12:07:25.5004393+00:00","category":"Flying"},{"model":"UBUUC","serialNumber":"VLNU9X9SQIU9HMN","manufacturedDate":"2022-04-04T12:07:25.500478+00:00","category":"Flying"},{"model":"UJU48","serialNumber":"QJKV2W0ZEDCHMV7","manufacturedDate":"2022-03-30T12:07:25.5004726+00:00","category":"Land"},{"model":"W0XY5","serialNumber":"1KWOI8FXF9L02S5","manufacturedDate":"2022-02-19T12:07:25.5004201+00:00","category":"Land"},{"model":"WY9UD","serialNumber":"OULU13P7ZLKFYBW","manufacturedDate":"2022-03-19T12:07:25.5004513+00:00","category":"Land"},{"model":"WYZKH","serialNumber":"OZU7LH2HHUHXDJW","manufacturedDate":"2022-04-05T12:07:25.5004791+00:00","category":"Land"},{"model":"XY1SJ","serialNumber":"Z9TDHJFS2MDIUOY","manufacturedDate":"2022-03-07T12:07:25.5004382+00:00","category":"Land"},{"model":"YNON1","serialNumber":"EA5TM99WG9R1SMM","manufacturedDate":"2022-03-04T12:07:25.500435+00:00","category":"Land"},{"model":"Z2T9G","serialNumber":"79RV5SRCFKK6TLO","manufacturedDate":"2022-02-28T12:07:25.5004303+00:00","category":"Land"},{"model":"ZKHIY","serialNumber":"B847OJUONX3RORU","manufacturedDate":"2022-02-25T12:07:25.5004269+00:00","category":"Land"},{"model":"ZPXII","serialNumber":"VQVFF9G6CPXU6NN","manufacturedDate":"2022-02-17T12:07:25.5004068+00:00","category":"Land"}]
        }
    },
    mounted(){
        this.loadSurvivors()
        this.loadRobots()
    },
    computed: {
        survivors(){
            if(this.survivorsList)
            return this.survivorsList
        },
        infectedPercentage(){
            return (this.infectedSurvivors / 100) * this.survivorsList.length
        },
        nonInfectedPercentage(){
            return (this.nonInfectedSurvivors / 100) * this.survivorsList.length
        }
    },
    methods: {
        async getSurvivor(){
           return await api.getById('/survivor/'+this.form.id)  
        },
        loadRobots(){
            robotAPI.getAll('/robotcpu')  
            .then(response => {  
                if(response.data){
                    console.log(response.data)
                    this.robotList =  response.data
                }
            })  
            .catch(error => {  
                console.log(error)  
            })  
        },
        loadSurvivors(){
            api.getAll('/survivors')  
            .then(response => {  
                if(response.data){
                    this.survivorsList =  response.data
                    for(var i = 0; i < response.data.length; i++){
                        //nonInfectedSurvivors
                        let survivorStatus = response.data[i].survivorStatus
                        if(survivorStatus == 3){
                            let data = {
                                id: response.data[i].id,
                                firstName: response.data[i].firstName,
                                lastName: response.data[i].lastName,
                            };
                            this.infections.push(data)
                            this.infectedSurvivors++
                        }else{
                            let data = {
                                id: response.data[i].id,
                                firstName: response.data[i].firstName,
                                lastName: response.data[i].lastName,
                            };
                            this.nonInfections.push(data)
                            this.nonInfectedSurvivors++

                        }
                    }
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

<style scoped>
    .service-card{
        margin-bottom: 50px
    }
    .service-card-deck{
        margin-bottom: 100px
    }

</style>
