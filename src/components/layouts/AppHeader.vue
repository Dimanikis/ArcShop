<script>
import LogoItem from '../LogoItem.vue';
import NavigationItem from '../NavigationItem.vue';
import BasketPreview from './BasketPreview.vue';
import { mapGetters } from 'vuex';

export default {
	data() {
		return {
			isActiveSearch: false,
			searchResult: [],
			isValid: false,
		};
	},
	components: { LogoItem, NavigationItem, BasketPreview },
	methods: {
		openBasket() {
			document.querySelector('.basket').classList.add('basket--active');
			document.body.classList.add('nonscroll');
		},
		search(event) {
			const request = event.target.value.trim();

			if (request.length >= 3) {
				this.isValid = true;

				let regExp = new RegExp(`^${request}| ${request}`, 'gi');
				this.searchResult = this.allProducts.filter((el) =>
					regExp.test(el.name)
				);

				let secondRexExp = new RegExp(request, 'gi');

				this.allProducts.forEach((el) => {
					if (secondRexExp.test(el.name) && !this.searchResult.includes(el))
						this.searchResult.push(el);
				});
			} else {
				this.isValid = false;
				this.searchResult.length = 0;
			}
		},
		closeSearch() {
			this.isActiveSearch = false;
			this.searchResult.length = 0;
			this.isValid = false;
		},
		handleClick(event) {
			if (
				!event.target.closest('.main-search') &&
				!event.target.closest('.main-search__label')
			) {
				this.closeSearch();
			}
		},
	},
	computed: {
		...mapGetters(['getBasketQty', 'allProducts']),
		getSearchResult() {
			return this.searchResult;
		},
	},
	watch: {
		$route() {
			this.isActiveSearch = false;
			this.searchResult.length = 0;
			this.isValid = false;
		},
	},
	created() {
		document.addEventListener('click', this.handleClick);
	},
	unmounted() {
		document.removeEventListener('click', this.handleClick);
	},
};
</script>

<template>
	<header class="header">
		<div class="container header__container">
			<NavigationItem class="header__nav" />
			<logo-item class="header__logo" v-show="!isActiveSearch" :isMain="true" />
			<div class="main-search" v-if="isActiveSearch">
				<input
					type="search"
					class="main-search__input"
					id="main-search"
					@input="search"
				/>
				<div
					v-if="getSearchResult.length == 0 && isValid"
					class="main-search__list"
				>
					<span>¯\_(ツ)_/¯</span>
					<span>Sorry...</span>
				</div>
				<div
					v-else-if="getSearchResult.length > 0 && isValid"
					class="main-search__list"
				>
					<router-link
						v-for="product in getSearchResult"
						:key="product.id"
						class="search-item"
						:to="{
							name: 'product',
							params: {
								productName: product.name
									.replace(/(\W|_)+/g, '-')
									.toLowerCase(),
								id: product.id,
							},
						}"
						@click="closeSearch"
					>
						<div class="search-item__img">
							<img
								loading="lazy"
								:src="require(`@/assets/img/products/${product.id}-1.png`)"
								:alt="product.name"
							/>
						</div>
						<span class="search-item__name">{{ product.name }}</span>
					</router-link>
				</div>
			</div>
			<div class="header__icons">
				<label
					class="header__icons-wrapper main-search__label"
					for="main-search"
					@click="
						isActiveSearch = !isActiveSearch;
						searchResult.length = 0;
						isValid = false;
					"
				>
					<svg class="svg-search-dims">
						<use xlink:href="@/assets/files/sprite.svg#search"></use>
					</svg>
				</label>
				<div class="header__icons-wrapper" @click="openBasket">
					<svg class="svg-busket-dims">
						<use xlink:href="@/assets/files/sprite.svg#busket"></use>
					</svg>
					<div class="basket-label" v-if="getBasketQty">{{ getBasketQty }}</div>
				</div>
			</div>
		</div>
		<BasketPreview />
	</header>
</template>

<style lang="scss">
input[type='search']::-webkit-search-decoration,
input[type='search']::-webkit-search-cancel-button,
input[type='search']::-webkit-search-results-button,
input[type='search']::-webkit-search-results-decoration {
	-webkit-appearance: none;
}

.search-item {
	display: flex;
	flex-direction: column;
	align-items: center;

	&:not(:last-child) {
		margin-bottom: 10px;
	}

	&:hover &__name {
		color: $color-main-green;
	}

	&__name {
		font-size: 10px;
		color: $color-black;
		text-transform: capitalize;
		transition: color 0.3s;
	}

	&__img {
		width: 40px;
		margin-bottom: 10px;

		img {
			object-fit: fill;
			width: 100%;
		}
	}
}

@media screen and (min-width: $tablet) {
	.search-item {
		flex-direction: row;

		&:not(:last-child) {
			margin-bottom: 15px;
		}

		&__name {
			font-size: 14px;
		}

		&__img {
			margin-right: 20px;
			margin-bottom: 0;
		}
	}
}

.main-search {
	flex: 1;
	margin-right: 150px;
	margin-left: 20px;
	transition: all 0.3;
	position: relative;
	background: $color-white;

	&__input {
		border: 1px solid $color-main-green;
		border-radius: 20px;
		@include px(10px);
		background: transparent;
		width: 100%;
		transition: all 0.3;
		min-height: 40px;
		line-height: 38px;
	}

	&__list {
		position: absolute;
		width: 100%;
		background: $color-white;
		padding: 20px 20px;
		border-radius: 0 0 20px 20px;
		box-shadow: 0 0 16px 12px rgba($color-main-green, 0.3);
		z-index: -1;

		span {
			display: block;
			font-size: 16px;
			text-align: center;
			color: $color-pale-black;

			&:not(:last-child) {
				margin-bottom: 15px;
				font-size: 25px;
			}
		}
	}
}

@media screen and (min-width: $tablet) {
	.main-search {
		width: 0;
		margin-right: 20px;

		&__input {
			@include px(20px);
		}
	}
}

.basket-label {
	border-radius: 100%;
	@include flex-center;
	height: 18px;
	line-height: 18px;
	min-width: 18px;
	position: absolute;
	top: -2px;
	left: 24px;
	font-size: 10px;
	font-weight: 500;
	background-color: $color-main-green;
	color: white;
}

.svg-busket-dims,
.svg-search-dims {
	@include wh(21px);
}

.header {
	background: white;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	z-index: 3;

	&__container {
		min-height: 80px;
		padding: 12px 20px !important;
		display: flex;
		flex-direction: row-reverse;
		align-items: center;
		justify-content: space-between;
	}

	&__icons {
		margin-right: 50px;
		position: absolute;
		right: 0;
		z-index: 5;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}

	&__icons-wrapper {
		position: relative;
		cursor: pointer;
		margin-right: 20px;
		@include flex-center;
		@include wh(40px);
		border-radius: 50px;
		background-color: $color-light-green;
		transition: all 0.3;

		&:hover {
			box-shadow: 0 0 20px 1px $color-main-green;
		}

		&__logo {
			order: 1;
		}
	}
}

@media screen and (min-width: $tablet) {
	.header__logo {
		order: 0;
		position: absolute;
		right: 50%;
		transform: translateX(50%);
	}
}

@media screen and (min-width: $tablet) {
	.header {
		&__container {
			flex-direction: row;
		}

		&__icons {
			position: unset;
			right: unset;
			z-index: unset;
			margin-right: 0;
		}
	}
}

@media screen and (min-width: $desktop) {
	.header {
		&__container {
			padding: 25px 10px !important;
		}
	}
}
</style>
