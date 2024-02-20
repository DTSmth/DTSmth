<template>
  <div>
    <AppHeader />
  </div>
  <div>
    <ShiftList :shifts="shifts" />
  </div>
</template>

<script>
import ShiftList from '../components/ShiftList.vue';
import apiService from '../services/apiService';
import AppHeader from '../components/AppHeader.vue';

export default {
  name: 'ClientShiftsView',
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
    // Your component methods go here
  },
  created() {
    apiService.getClientShifts(this.clientId)
      .then(response => {
        this.shifts = response.data;
      })
      .catch(error => {
        console.log(error);
      });
  },
  props: ['clientId']
};
</script>

<style scoped>
/* Your component styles go here */
</style>
