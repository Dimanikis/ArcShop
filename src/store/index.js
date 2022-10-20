import { createStore } from 'vuex';
import products from './modules/products';
import basket from './modules/basket';

const store = createStore({
	modules: {
		products,
		basket,
	},
});

export default store;
