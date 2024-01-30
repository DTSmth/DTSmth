<template>
    <div class="client" v-for="client in clients" v-bind:key="clients.id">
        <span>{{ client.firstName }} </span>
        <span>{{ client.lastName }} </span>
        <span>{{ client.hasPersonalCare }}</span>
        <span>{{ client.hasLifting }}</span>
        <span>{{ client.address1 }}</span>
        <span>{{ client.address2 }}</span>
        <span>{{ client.zipcode }}</span>
        <span>{{ client.phoneNumber }}</span>

        
    </div>
</template>

<script>
import apiService from '../services/apiService';

export default {
    data() {
        return {
            clients: []
        }
    },
    methods: {
        getClients() {
            apiService.list()
                .then(response => {
                    this.clients = response.data;
                    console.log('in then ' + this.clients)
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    created() {
        console.log('calling get clients')
        this.getClients()
    }
    
}
</script>

<style scoped>
/* Your style code here */
</style>
