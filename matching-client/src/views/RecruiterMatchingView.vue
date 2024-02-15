<template>
    <div>
        <header>
            <h1>Abound Recruiting</h1>
        </header>
        <section>
            <ClientsList />
        </section>
    </div>
</template>

<!-- // clean this up ^^^^ -->

<script>
import ClientsList from '../components/ClientsList.vue'; // Import the component


export default {
    name: 'RecruiterMatchingView',
    components: {
    ClientsList 
  }
   
}
</script>

<style scoped>
/* Your component's CSS styles go here */

</style>
