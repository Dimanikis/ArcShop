<script>
import AOS from 'aos';
import 'aos/dist/aos.css';

import { mapActions } from 'vuex';
import AppHeader from './components/layouts/AppHeader.vue';
import AppFooter from './components/layouts/AppFooter.vue';
import ScrollTop from './components/layouts/ScrollTop.vue';
import OrderConfirmation from './components/layouts/OrderConfirmation.vue';

export default {
	name: 'App',
	components: { AppHeader, AppFooter, ScrollTop, OrderConfirmation },
	methods: mapActions(['fetchProducts', 'getBasketData']),

	async mounted() {
		AOS.init();
		this.fetchProducts();
		this.getBasketData();
	},
};
</script>

<template>
	<AppHeader />
	<main class="main">
		<router-view />
	</main>
	<AppFooter />
	<ScrollTop />
	<OrderConfirmation />
</template>

<style lang="scss">
.main {
	padding-top: 80px;
}

@media screen and (min-width: $desktop) {
	.main {
		padding-top: 90px;
	}
}

body.nonscroll {
	overflow: hidden;
}

* {
	color: $color-black;
	font-family: 'DM Sans', sans-serif;
	scroll-behavior: smooth;
}

.container {
	@include max-res-width(1260px);
	@include px(10px);
	margin: 0 auto;
}
</style>
