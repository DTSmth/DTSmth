<template>
  <div class ="table-container">
    <table class="shift-table">
        <thead>
            <tr>
            <th>Shift ID</th>
            <th>Client ID</th>
            <th>Total Hours</th>
            <th>Location</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Service Name</th>
            
            </tr>
        </thead>
        <tbody>
            <tr v-for="shift in shifts" :key="shift.shiftId">
            <td>{{ shift.shiftId }}</td>
            <td>{{ shift.clientId }}</td>
            <td>{{ shift.totalHours }}</td>
            <td>{{ shift.zipcode }}</td>
            <td>{{ shift.firstName }}</td>
            <td>{{ shift.lastName }}</td>
            <td>{{ shift.serviceName }}</td>
            <!-- <td>
                <button @click="editShift(shift.shiftId)">Edit</button>
                <button @click="deleteShift(shift.shiftId)">Delete</button>
            </td> -->
            </tr>
        </tbody>
    </table>
  </div>
</template>

<script>


export default {
  name: 'ShiftList',
  data() {
    return {
      // Your component data goes here
    };
  },
  methods: {
    // Your component methods go here
  },
  props: {
    shifts: Array
  }
};
</script>

<style scoped>

body {
  font-family: Arial, sans-serif;
  margin: 20px;
}
.table-container {
  display: flex;
  justify-content: center;
}

.shift-table {
  width: 100%;
  border-collapse: collapse;
  background-color: #fff;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.shift-table th,
.shift-table td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: left;
}

.shift-table th {
  background-color: #1A1348;
  font-weight: bold;
  color: #fff;
}

.shift-table tbody tr:nth-child(even) {
  background-color: #B1DFFC;
}

.shift-table tbody tr:hover {
  background-color: #f5f5f5;
  cursor: pointer;
}

.shift-table td {
  color: #333;
}

.shift-table td a {
  color: #007bff;
  text-decoration: none;
}

.shift-table td a:hover {
  text-decoration: underline;
}
</style>
