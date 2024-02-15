<template>
    <div class="search-bar">
      <input v-model="search" placeholder="Search...">
    </div>
    <div class="table-container">
        <table class="client-table">
        <thead>
            <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Personal Care</th>
            <th>Lifting</th>
            <th>Address 1</th>
            <th>Address 2</th>
            <th>Zipcode</th>
            <th>Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <client-info v-for="client in clients" :key="client.id" :client="client" />
        </tbody>
        </table>
    </div>
</template>

<script>
import apiService from '../services/apiService';
import ClientInfo from './ClientInfo.vue';

export default {
    components: {
        ClientInfo
    },
    data() {
        return {
            clients: []
        }
    },
    methods: {
        getClients() {
            apiService.listClients()
                .then(response => {
                    this.clients = response.data;
                    console.log('in then ' + this.clients)
                })
                .catch(error => {
                    console.log(error);
                });
        },
    },
    computed: {
    filteredClients() {
      return this.clients.filter(client =>
        client.firstName.toLowerCase().includes(this.search.toLowerCase()) ||
        client.lastName.toLowerCase().includes(this.search.toLowerCase())
        
      );
    }
  },


    created() {
        console.log('calling get clients')
        this.getClients()
    }
    
}
</script>

<style>

body {
  font-family: Arial, sans-serif;
  margin: 20px;
}

.search-bar {
  margin-bottom: 20px;
}

.table-container {
  display: flex;
  justify-content: center;
}

.client-table {
  width: 100%;
  border-collapse: collapse;
  background-color: #fff;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.client-table th,
.client-table td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: left;
}

.client-table th {
  background-color: #1A1348;
  font-weight: bold;
  color: #fff;
}

.client-table tbody tr:nth-child(even) {
  background-color: #B1DFFC;
}

.client-table tbody tr:hover {
  background-color: #f5f5f5;
  cursor: pointer;
}

.client-table td {
  color: #333;
}

.client-table td a {
  color: #007bff;
  text-decoration: none;
}

.client-table td a:hover {
  text-decoration: underline;
}


</style>
