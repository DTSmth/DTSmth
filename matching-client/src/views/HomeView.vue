<template>
    <div>
       <AppHeader />
    </div>
    <div id="login-container">
        <input type="text" v-model="username" placeholder="Username">
        <input type="password" v-model="password" placeholder="Password">
        <button @click="login">Login</button>
    </div>  
</template>

<script>
import AppHeader from '../components/AppHeader.vue';
import apiService from '../services/apiService';


export default {
    name: 'HomeView',
    components: {
        AppHeader,
    },
    data() {
        return {
            username: '',
            password: ''
        };
    },
    methods: {
        login() {
            let credentials =   {
                username: this.username,
                password: this.password}
            apiService.login(credentials)
                .then(response => {
                    this.$store.commit("SET_AUTH_TOKEN", response.data.token);
                    this.$store.commit("SET_USER", response.data.user);
                    this.$router.push({ name: 'RecruiterMatchingView'});
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    
}

</script>

<style scoped>

input[type="text"],
input[type="password"] {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 200px;
}

#login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 100px;
}

</style>
