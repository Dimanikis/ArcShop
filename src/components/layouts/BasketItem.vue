<script>
import { mapMutations } from 'vuex';

export default {
	props: {
		product: {},
	},
	methods: {
		...mapMutations(['changeProductQty', 'removeProductFromBasket']),
		handleQty(event) {
			this.changeProductQty({ ...this.product, qty: event.target.value });
		},
		qtyIncrement() {
			this.changeProductQty({ ...this.product, qty: this.product.qty + 1 });
		},
		qtyDecrement() {
			this.changeProductQty({
				...this.product,
				qty: this.product.qty - 1 > 0 ? this.product.qty - 1 : this.product.qty,
			});
		},
		deleteProduct() {
			this.removeProductFromBasket(this.product);
		},
	},
};
</script>

<template>
	<div class="basket-item">
		<div class="basket-item__img">
			<img
				:src="require(`@/assets/img/products/${product.id}-1.png`)"
				:alt="product.name"
			/>
		</div>
		<div class="basket-item__details">
			<router-link
				:to="{
					name: 'product',
					params: {
						productName: product.name.replace(/(\W|_)+/g, '-').toLowerCase(),
						id: product.id,
					},
				}"
				class="basket-item__name"
			>
				{{ product.name }}
			</router-link>
			<span class="basket-item__price"
				>Price: {{ product.promo || product.price }}$</span
			>
			<div class="quantity basket-item__quantity">
				<button class="quantity__btn quantity__btn--left" @click="qtyDecrement">
					-
				</button>
				<input
					type="number"
					min="1"
					class="quantity__input"
					:value="product.qty"
					@input="handleQty"
				/>
				<button
					class="quantity__btn quantity__btn--right"
					@click="qtyIncrement"
				>
					+
				</button>
			</div>
		</div>
		<button
			class="material-symbols-outlined basket-item__delete"
			@click="deleteProduct"
		>
			delete
		</button>
	</div>
</template>

<style lang="scss">
.basket-item {
	display: flex;
	width: 100%;
	align-items: center;
	gap: 10px;

	&__img {
		min-width: 30%;
		max-width: 30%;

		img {
			object-fit: fill;
			width: 100%;
		}
	}

	&__details {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		gap: 10px;
	}

	&__name {
		font-size: 14px;
		text-transform: capitalize;
		font-weight: 500;
		transition: color 0.3s;

		&:hover {
			color: $color-main-green;
		}
	}

	&__price {
		font-size: 14px;
	}

	&__quantity {
		max-width: 150px;
		max-height: 28px;
	}

	&__delete {
		color: $color-main-green;
		background: transparent;
		padding: 5px 10px;
		align-self: flex-start;
		transition: color 0.2s;

		&:hover {
			color: #df2437;
		}
	}
}
</style>
