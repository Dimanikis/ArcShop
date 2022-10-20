<script>
import { mapMutations } from 'vuex';

export default {
	props: ['product'],
	computed: {
		discount() {
			return ~~((this.product.promo / this.product.price - 1) * 100);
		},
	},
	methods: {
		...mapMutations(['addProductToBasket']),
		addToBasket() {
			this.addProductToBasket({ ...this.product, qty: 1 });
		},
	},
};
</script>

<template>
	<li class="shop__item product-item">
		<div class="product-item__labels">
			<div
				v-if="product.promo"
				class="product-item__label product-item__label--discount"
			>
				{{ discount }}%
			</div>
			<div
				v-if="product.hot"
				class="product-item__label product-item__label--hot"
			>
				hot
			</div>
			<div
				v-if="product.new"
				class="product-item__label product-item__label--new"
			>
				new
			</div>
		</div>
		<router-link
			:to="{
				name: 'product',
				params: {
					productName: product.name.replace(/(\W|_)+/g, '-').toLowerCase(),
					id: product.id,
				},
			}"
			v-if="product.images.split(',').length === 1"
			class="product-item__picture"
		>
			<img
				loading="lazy"
				class="product-item__frst-img"
				:src="require(`@/assets/img/products/${product.id}-1.png`)"
				:alt="product.name"
			/>
		</router-link>
		<router-link
			:to="{
				name: 'product',
				params: {
					productName: product.name.replace(/(\W|_)+/g, '-').toLowerCase(),
					id: product.id,
				},
			}"
			v-else
			class="product-item__picture product-item__picture--double"
		>
			<img
				loading="lazy"
				class="product-item__frst-img"
				:src="require(`@/assets/img/products/${product.id}-1.png`)"
				:alt="product.name"
			/>
			<img
				loading="lazy"
				class="product-item__scnd-img"
				:src="require(`@/assets/img/products/${product.id}-2.png`)"
				:alt="product.name"
			/>
		</router-link>

		<div class="product-item__btm">
			<router-link
				:to="{
					name: 'product',
					params: {
						productName: product.name.replace(/(\W|_)+/g, '-').toLowerCase(),
						id: product.id,
					},
				}"
				class="product-item__name"
			>
				{{ product.name }}
			</router-link>

			<div v-if="!product.promo" class="product-item__price">
				$ {{ product.price }}
			</div>
			<div v-else class="product-item__price">
				${{ product.promo }}
				<span class="product-item__price--reduced">${{ product.price }}</span>
			</div>
			<button class="product-item__btn" @click="addToBasket">buy now</button>
		</div>
	</li>
</template>

<style lang="scss" scoped>
.product-item {
	width: 300px;
	min-height: 380px;
	height: 100%;
	border: 1px solid rgba($color-pale-black, 0.2);
	background: $color-light-green;
	transition: all 0.4s;
	position: relative;
	display: flex;
	flex-direction: column;

	&:hover {
		box-shadow: 0 12px 18px rgba($color-main-green, 0.3);
	}

	&__labels {
		position: absolute;
		z-index: 2;
		top: 15px;
		right: 10px;
		display: flex;
		flex-direction: column;
		gap: 5px;
	}

	&__label {
		color: #fff;
		font-weight: 700;
		text-transform: capitalize;
		font-size: 12px;
		height: 20px;
		line-height: 20px;
		padding: 0 10px;
		border-radius: 10px;
		box-shadow: 0 1px 2px #0003;
		text-align: center;

		&--discount {
			background: $color-main-green;
		}

		&--hot {
			background: $color-pale-yellow;
		}
		&--new {
			background: $color-pale-red;
		}
	}

	&__picture {
		position: relative;
		width: 100%;
		height: 245px;
		overflow: hidden;

		img {
			width: 100%;
			object-fit: contain;
			transition: all 0.4s;
		}
	}

	&__scnd-img {
		position: absolute;
		top: 0;
		right: 0;
		opacity: 0;
		visibility: hidden;
	}

	&__picture:hover &__frst-img {
		transform: scale(1.4);
	}

	&__picture--double:hover &__frst-img {
		opacity: 0;
		visibility: hidden;
		transform: scale(1);
	}

	&__picture--double:hover &__scnd-img {
		opacity: 1;
		visibility: visible;
	}

	&__btm {
		flex: 1;
		padding: 15px 25px 25px;
		display: flex;
		flex-direction: column;
		align-items: center;
		height: auto;
	}

	&__name {
		font-weight: 500;
		font-size: 14px;
		line-height: 1.5;
		text-align: center;
		text-transform: capitalize;
		margin-bottom: 10px;
		flex: 1;
		transition: color 0.3s;

		&:hover {
			color: $color-main-green;
		}
	}

	&__price {
		font-weight: 500;
		font-size: 14px;
		line-height: 1.5;
		color: $color-main-green;
		margin-bottom: 10px;

		&--reduced {
			color: rgba($color-pale-black, 0.5);
			text-decoration: line-through;
		}
	}

	&__btn {
		font-weight: 500;
		font-size: 12px;
		line-height: 1;
		padding: 5px 10px;
		background: $color-main-green;
		border: 1px solid $color-main-green;
		text-transform: capitalize;
		border-radius: 30px;
		color: #fff;
		transition: all 0.3s;

		&:hover {
			color: $color-main-green;
			background: #fff;
		}
	}
}
</style>
