<template>
    <tr>
        <td>{{ client.firstName }}</td>
        <td>{{ client.lastName }}</td>
        <td>{{ client.hasPersonalCare }}</td>
        <td>{{ client.hasLifting }}</td>
        <td>{{ client.address1 }}</td>
        <td>{{ client.address2 }}</td>
        <td>{{ client.zipcode }}</td>
        <td>{{ client.phoneNumber }}</td>
    </tr> 
</template>

<script>
export default {
    name: 'ClientInfo',
    
    props: ['client'],
    
    data() {
        return {
            // Your component's data goes here
        };
    },
    methods: {
        // Your component's methods go here
    },
    mounted() {
        // Code to run when the component is mounted goes here
    }
    
};
</script>

<style scoped>

</style>
