<template>
  <div>
    <AppHeader />
  </div>
  <div>
    <ShiftList :shifts="shifts" />
  </div>
</template>

<script>
import apiService from '../services/apiService';
import AppHeader from '../components/AppHeader.vue';
import ShiftList from '../components/ShiftList.vue';


export default {
    
    data() {
        return {
          shifts: [],
        };
    },
    methods: {
    // Your methods here
    },
    components: { 
      AppHeader,
      
    },
    created() {
        apiService.getShift(this.$route.params.shiftId)
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
