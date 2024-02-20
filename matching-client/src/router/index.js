import { createRouter as _createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import RecruiterMatchingView from '../views/RecruiterMatchingView.vue'
import RecruiterShiftsView from '../views/RecruiterShiftsView.vue'
import ClientShiftsView from '../views/ClientShiftsView.vue'

const routes = [
    {
        path: '/',
        component: Home,
        name: 'Home'
    },
    {   
        
        path: '/recruiting/clients',
        component: RecruiterMatchingView,
        name: 'RecruiterMatchingView'
    },
    {
        path: '/recruiting/shifts',
        component: RecruiterShiftsView,
        name: 'RecruiterShiftsView'
    
    },
    {
        path: '/recruiting/clients/:clientId/shifts',
        component: ClientShiftsView,
        name: 'ClientShiftsView',
        props: true
    }
]



export function createRouter() {
    return _createRouter({
        history: createWebHistory(),
        routes: routes
    })
}