<script>
import { mapGetters, mapMutations } from 'vuex';
import BasketItem from './BasketItem.vue';
import GreenBtn from '../GreenBtn.vue';

export default {
	computed: {
		...mapGetters(['getBasketProducts', 'getBasketAmount']),
	},
	methods: {
		...mapMutations(['clearBasketData']),
		closeBasket() {
			document.querySelector('.basket').classList.remove('basket--active');
			document.body.classList.remove('nonscroll');
		},
		openBasket() {
			document.querySelector('.basket').classList.add('basket--active');
			document.body.classList.add('nonscroll');
		},
		orderConfirm() {
			if (this.getBasketAmount) {
				this.clearBasketData();
				document.querySelector('.basket').classList.remove('basket--active');
				document
					.querySelector('.order-confirm')
					.classList.add('order-confirm--active');
			}
		},
	},
	watch: {
		$route() {
			this.closeBasket();
		},
		getBasketAmount(newVal, old) {
			if (newVal > old) this.openBasket();
		},
	},
	components: { BasketItem, GreenBtn },
};
</script>

<template>
	<div class="basket">
		<div class="basket__header">
			<h3 class="basket__title">My shopping cart</h3>
			<button
				class="material-symbols-outlined basket__close"
				@click="closeBasket"
			>
				close
			</button>
		</div>
		<div class="basket__content" v-if="getBasketProducts?.length">
			<BasketItem
				v-for="product in getBasketProducts"
				:key="product.id"
				:product="product"
			/>
		</div>
		<div v-else class="basket__content basket__content--empty">
			<span class="basket__empty-msg basket__empty-msg--big"> ¯\_(ツ)_/¯ </span>
			<span class="basket__empty-msg">Your cart is empty</span>
		</div>
		<div v-show="getBasketAmount" class="basket__footer">
			<div class="basket__amount">
				<span>Total:</span>
				<span>${{ getBasketAmount }} USD</span>
			</div>
			<GreenBtn class="basket__checkout" @click="orderConfirm"
				>Checkout</GreenBtn
			>
		</div>
	</div>
	<div class="basket-overlay" @click="closeBasket"></div>
</template>

<style lang="scss">
.basket-overlay {
	content: '';
	position: fixed;
	width: 100vw;
	height: 100vh;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	z-index: 4;
	transition: all 0.2s ease-in-out;
	background-color: rgba(0, 0, 0, 0.5);
	opacity: 0;
	visibility: hidden;
}

.basket {
	@include max-res-width(100%);
	position: fixed;
	top: 0;
	right: 0;
	bottom: 0;
	background: white;
	transform: translateX(100%);
	transition: transform 0.3s;
	z-index: 5;
	display: flex;
	flex-direction: column;

	&--active {
		transform: translateX(0%);
		& + .basket-overlay {
			opacity: 1;
			visibility: visible;
		}
	}

	&__header {
		padding: 13px 20px;
		display: flex;
		align-items: center;
		justify-content: space-between;
		border-bottom: 1px solid rgba($color-pale-black, 0.2);
	}

	&__title {
		line-height: 20px;
		font-size: 22px;
		font-weight: 500px;
	}

	&__close {
		font-size: 35px;
		background: transparent;
		transition: color 0.3s;

		&:hover {
			color: $color-main-green;
		}
	}

	&__content {
		padding: 30px 20px;
		flex: 1;
		overflow: auto;
		display: flex;
		flex-direction: column;
		gap: 30px;

		&--empty {
			gap: 20px;
			justify-content: center;
		}
	}

	&__footer {
		border-top: 1px solid rgba($color-pale-black, 0.2);
		padding: 20px 20px 30px;
	}

	&__amount {
		display: flex;
		justify-content: space-between;
		margin-bottom: 20px;

		span {
			font-size: 16px;
			line-height: 1em;
			font-weight: 500;
		}
	}

	&__empty-msg {
		font-size: 16px;
		text-align: center;
		color: $color-pale-black;

		&--big {
			font-size: 30px;
		}
	}

	&__checkout {
		width: 100%;
		text-align: center;
		text-transform: uppercase !important;
	}
}

@media screen and (min-width: 550px) {
	.basket {
		max-width: 340px;
	}
}
</style>
