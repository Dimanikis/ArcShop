import { createApp } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';
import store from './store';
import App from './App.vue';
import Home from '@/components/pages/HomePage.vue';
import Store from '@/components/pages/ShopPage.vue';
import AboutUs from '@/components/pages/AboutUs.vue';
import Contact from '@/components/pages/ContactPage.vue';
import Product from '@/components/pages/ProductPage.vue';

const router = createRouter({
	history: createWebHashHistory('/organic-healty-food/'),
	routes: [
		{
			path: '/',
			name: 'home',
			component: Home,
		},
		{
			path: '/store',
			name: 'store',
			component: Store,
		},
		{
			path: '/store/:productName' + '-' + ':id',
			name: 'product',
			component: Product,
			props: true,
		},
		{
			path: '/about-us',
			name: 'about-us',
			component: AboutUs,
		},
		{
			path: '/contact',
			name: 'contact',
			component: Contact,
		},
	],
	linkActiveClass: 'active',
	scrollBehavior() {
		document.getElementById('app').scrollIntoView({ behavior: 'smooth' });
	},
});

const app = createApp(App);

app.use(router);
app.use(store);

app.mount('#app');
