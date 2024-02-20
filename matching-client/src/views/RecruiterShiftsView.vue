<template>
  <div>
    <AppHeader />
  </div>
  <div>
    <ShiftList :shifts="shifts"/>
  </div>
</template>

<script>
import ShiftList from '../components/ShiftList.vue';
import apiService from '../services/apiService';
import AppHeader from '../components/AppHeader.vue';

export default {
  name: 'RecruiterShiftsView',
  data() {
    return {
      shifts: [],
    };
    
  },
  components: {
    ShiftList,
    AppHeader
  },
  methods: {
    // Your methods here
  },
  created() {
    apiService.listShifts()
      .then(response => {
        this.shifts = response.data;
      })
      .catch(error => {
        console.log(error);
      });
  },
};
</script>

<style scoped>
/* Your component styles here */
</style>
