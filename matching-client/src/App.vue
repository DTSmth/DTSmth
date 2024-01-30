
<template>
  <div>
    
    <header>
      <h1> Abound Recruiting</h1>
    </header>
    <section>
      <ClientInfo />
    </section>
  </div>
</template>

<script>
import ClientInfo from './components/ClientInfo.vue'; // Import the component
 
export default {
  name: 'App',
  components: {
    ClientInfo // Add the component to your component list
  }
}

</script>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
