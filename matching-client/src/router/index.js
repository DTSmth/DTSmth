import { createRouter as _createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RecruiterMatchingView from '../views/RecruiterMatchingView.vue'
import RecruiterShiftsView from '../views/RecruiterShiftsView.vue'
import RecruiterClientShiftsView from '../views/RecruiterClientShiftsView.vue'
import RecruiterSingleShiftView from '../views/RecruiterSingleShiftView.vue'
import { useStore } from 'vuex'

const routes = [
    {
        path: '/',
        component: HomeView,
        name: 'Home'
    },
    {   
        
        path: '/recruiting/clients',
        component: RecruiterMatchingView,
        name: 'RecruiterMatchingView',
        meta: { requiresAuth: true }
    },
    {
        path: '/recruiting/shifts',
        component: RecruiterShiftsView,
        name: 'RecruiterShiftsView',
        meta: { requiresAuth: true }
        
    
    },
    {
        path: '/recruiting/clients/:clientId/shifts',
        component: RecruiterClientShiftsView,
        name: 'ClientShiftsView',
        props: true,
        meta: { requiresAuth: true }
    },
    {
        path: '/recruiting/clients/:clientId/:shiftId',
        component: RecruiterSingleShiftView,
        name: 'RecruiterSingleShiftView',
        props: true,
        meta: { requiresAuth: true }
    }
]



export function createRouter() {
    const router = _createRouter({
        history: createWebHistory(),
        routes: routes
    })

    router.beforeEach((to) => {

        // Get the Vuex store
        const store = useStore();
      
        // Determine if the route requires Authentication
        const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
      
        // If it does and they are not logged in, send the user to "/login"
        if (requiresAuth && store.state.token === '') {
          return {name: "Home"};
        } 
        // Otherwise, do nothing and they'll go to their next destination
      });

    return router;
}
