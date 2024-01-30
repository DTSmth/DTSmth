import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import { createStore} from './store'
import { createRouter} from './router'

const store = createStore();
const router = createRouter();






const app = createApp(App)
app.use(store);
app.use(router);
app.mount('#app');



