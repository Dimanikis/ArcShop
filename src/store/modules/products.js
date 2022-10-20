export default {
	actions: {
		async fetchProducts(ctx) {
			const res = await fetch('https://sheetdb.io/api/v1/piolx43w5m6nb');
			const products = await res.json();
			ctx.commit('updateProducts', products);
		},
	},
	mutations: {
		updateProducts(state, products) {
			state.products = products;
			state.isLoaded = true;
		},
	},
	state: {
		products: [],
		isLoaded: false,
	},
	getters: {
		allProducts(state) {
			return state.products;
		},
		featureProducts(_, getters) {
			return getters.allProducts.filter((el) => el.promo || el.hot || el.new);
		},
		allFilters(_, getters) {
			let result = ['all'];

			getters.allProducts
				.map((el) => el.category)
				.forEach((el) => {
					if (!result.includes(el)) result.push(el);
				});

			return result;
		},
		featureFilters(_, getters) {
			let result = ['all'];

			getters.featureProducts
				.map((el) => el.category)
				.forEach((el) => {
					if (!result.includes(el)) result.push(el);
				});

			return result;
		},
		isLoaded(state) {
			return state.isLoaded;
		},
	},
};
