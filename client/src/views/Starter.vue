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
                    <div class="col-lg-7 text-center ">
                        <h4 class="lead text-white mt-4 mb-5">… the future of humankind is in your hands!!!</h4>
                    </div>
                </div>
        </div>
        <div class="container">
             <div class="row">
                <b-card-group deck class="card-columns d-flex justify-content-center service-card-deck">
                            <b-card
                                title="Report"
                                img-src="img/brand/report.png"
                                img-alt="Image"
                                img-top
                                tag="article"
                                style="max-width: 20rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                Report Contamination of Survivor.
                                </b-card-text>
                                <router-link to="/report" title="Report page">
                                    <b-button block  size="lg" variant="primary">Click Here</b-button>
                                </router-link>
                            </b-card>

                            <b-card
                                title="New Location"
                                img-src="img/brand/location.jpg"
                                img-alt="Image"
                                img-top
                                tag="article"
                                style="max-width: 20rem;"
                                class="card-lift--hover shadow border-0 service-card"
                            >
                                <b-card-text>
                                Update your new Geo-Location.
                                </b-card-text>
                                <router-link to="/newlocation" title="Location page">
                                    <b-button block  size="lg" variant="success">Click Here</b-button>
                                </router-link>
                             </b-card>
                </b-card-group>
            </div>
        </div>
</div>
</template>
<script>

export default {

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
