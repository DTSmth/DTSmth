<template>
    <div>
        <!-- Your template code here -->
        <p>Client Info</p>

    </div>
</template>

<script>
export default {
    data() {
        return {
            clients: []
        }
    },
    methods: {
        getClients() {
            // Fetch the clients from the API
            fetch('http://localhost:9000/clients')
                .then(response => response.json())
                .then(data => {
                    this.clients = data;
                })
                .catch(error => console.error(error));
        }
    },  
}
</script>

<style scoped>
/* Your style code here */
</style>
