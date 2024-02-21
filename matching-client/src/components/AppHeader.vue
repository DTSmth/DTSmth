<template>
  <div id="app-header">
    <img src="../assets/abound-logo-color.svg" alt="Abound Logo">
  </div>
  <nav id="nav-bar">
      <a @click="goToHome">Home</a>
      <a @click="goToClients">Clients</a>
      <a @click="goToShifts">Shifts</a>
      <a @click="logout">Logout</a>
  </nav>
</template>

<script>
export default {
  name: 'AppHeader',
  methods: {
    logout() {
      this.$store.commit("LOGOUT", null);
      this.$router.push({ name: 'Home'});
    },
    goToShifts() {
      this.$router.push({ name: 'RecruiterShiftsView'});
    },
    goToClients() {
      this.$router.push({ name: 'RecruiterMatchingView'});
    },
    goToHome() {
      this.$router.push({ name: 'Home'});
    }
  }
  // Your component options go here
}
</script>

<style scoped>
/* Your component styles go here */
#app-header {
  display: flex;
  justify-content: center;
  align-items: center;
}

#nav-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
}

#nav-bar a {
  margin: 0 10px;
  color: #1A1348;
  text-decoration: none;
  font-weight: bold;
  
}

#nav-bar a:hover {
  color: #666;
  cursor: pointer;
  font-weight: bold;

}

</style>
