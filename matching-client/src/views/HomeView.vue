<template>
    <div>
       <AppHeader />
    </div>
    <div>
        <input type="text" v-model="username" placeholder="Username">
        <input type="password" v-model="password" placeholder="Password">
    </div>  
</template>

<script>
import AppHeader from '../components/AppHeader.vue';


export default {
    name: 'HomeView',
    components: {
        AppHeader
    }
    
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

</style>
