<template>
    <div>
        <div>
            <AppHeader />
        </div>
        <section>
            <ClientsList />
        </section>
    </div>
</template>

<script>
import ClientsList from '../components/ClientsList.vue';
import AppHeader from '../components/AppHeader.vue';

export default {
    name: 'RecruiterMatchingView',
    components: {
    ClientsList,
    AppHeader 
  }
   
}
</script>

<style scoped>
/* Your component's CSS styles go here */

</style>
