export default {
	actions: {
		getBasketData(ctx) {
			let products;

			localStorage.getItem('basket')
				? (products = JSON.parse(localStorage.getItem('basket')))
				: (products = []);

			ctx.commit('updateBasketData', products);
		},
	},
	mutations: {
		updateBasketData(state, products) {
			state.products = products;
		},
		clearBasketData(state) {
			state.products.length = 0;
		},
		addProductToBasket(state, newProduct) {
			let result = false;

			state.products.forEach((el) => {
				if (el.id == newProduct.id) {
					el.qty += newProduct.qty;
					result = true;
					localStorage.setItem('basket', JSON.stringify(state.products));
					return;
				}
			});

			if (result) return;

			state.products.push(newProduct);
			localStorage.setItem('basket', JSON.stringify(state.products));
		},
		removeProductFromBasket(state, product) {
			state.products = state.products.filter((el) => el.id != product.id);
			localStorage.setItem('basket', JSON.stringify(state.products));
		},
		changeProductQty(state, newProduct) {
			state.products.forEach((el) => {
				if (el.id == newProduct.id) el.qty = +newProduct.qty;
				return;
			});

			localStorage.setItem('basket', JSON.stringify(state.products));
		},
	},
	state: {
		products: [],
	},
	getters: {
		getBasketProducts(state) {
			return state.products;
		},
		getBasketQty(state) {
			return state.products.reduce((total, el) => total + el.qty, 0);
		},
		getBasketAmount(state) {
			return state.products.reduce(
				(total, el) => total + el.qty * (el.promo || el.price),
				0
			);
		},
	},
};
