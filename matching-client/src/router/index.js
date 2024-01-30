import { createRouter as _createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import RecruiterMatching from '../views/RecruiterMatchingView.vue'

const routes = [
    {
        path: '/',
        component: Home,
        name: 'Home'
    },
    {
        path: '/recruiting',
        component: RecruiterMatching,
        name: 'RecruiterMatchingView'
    }
]



export function createRouter() {
    return _createRouter({
        history: createWebHistory(),
        routes: routes
    })
}