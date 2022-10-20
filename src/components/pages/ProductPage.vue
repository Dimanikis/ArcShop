<script>
import { mapGetters, mapMutations } from 'vuex';
import { ref } from 'vue';
import { Thumbs, Navigation, Pagination } from 'swiper';
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/css';
import 'swiper/css/pagination';
import 'swiper/css/navigation';

import GreenBtn from '../GreenBtn.vue';
import InnerHero from '../layouts/InnerHero.vue';
import FsLightbox from 'fslightbox-vue/v3';
import NewsletterSection from '../layouts/NewsletterSection.vue';

export default {
	data() {
		return {
			quantity: 1,
			product: false,
			toggler: false,
			slide: 1,
		};
	},
	computed: {
		...mapGetters(['allProducts', 'isLoaded']),
	},
	methods: {
		...mapMutations(['addProductToBasket']),
		addToBasket() {
			this.addProductToBasket({ ...this.product, qty: this.quantity });
		},
		getProduct(route) {
			const id = route.params.id?.toString().match(/\d{6}$/);

			this.product = this.allProducts.filter((el) => el.id == id)[0];
		},
		tabsHandler(event) {
			const target = event.target;
			const tabs = document.querySelectorAll('.tabs__item');
			const tabsContent = document.querySelectorAll('.tabs__content');

			tabs.forEach((el) => {
				el.classList.remove('tabs__item--active');
			});
			target.classList.add('tabs__item--active');

			tabsContent.forEach((el) => {
				el.classList.remove('tabs__content--active');

				if (el.dataset.id == target.dataset.id) {
					el.classList.add('tabs__content--active');
				}
			});
		},
		openLightboxOnSlide: function (number) {
			this.slide = number;
			this.toggler = !this.toggler;
		},
	},
	mounted() {
		if (this.isLoaded) {
			this.getProduct(this.$route);
		}
	},

	watch: {
		$route(newRoute) {
			if (newRoute.name == 'product') this.getProduct(newRoute);
		},
		isLoaded() {
			this.getProduct(this.$route);
		},
	},
	components: {
		Swiper,
		SwiperSlide,
		GreenBtn,
		InnerHero,
		FsLightbox,
		NewsletterSection,
	},
	setup() {
		const thumbsSwiper = ref(null);
		const setThumbsSwiper = (swiper) => {
			thumbsSwiper.value = swiper;
		};
		return {
			Thumbs,
			thumbsSwiper,
			setThumbsSwiper,
			Pagination,
			Navigation,
		};
	},
};
</script>

<template>
	<InnerHero
		:title="product.name"
		:gapLinks="[{ name: 'store', link: '/store/' }]"
		>{{ product.name }}</InnerHero
	>
	<section class="product">
		<div v-if="!product" class="preloader">
			<img src="@/assets/img/preloader.gif" alt="avocado" />
		</div>
		<div v-else class="container product__container">
			<FsLightbox
				:toggler="toggler"
				:slide="slide"
				:sources="
					product.images
						.split(',')
						.map((el) => require(`@/assets/img/products/${el}.png`))
				"
			/>
			<div class="product__header">
				<div class="product__photo-wrapper">
					<div
						class="product__photo"
						v-if="product.images.split(',').length === 1"
						@click="toggler = !toggler"
					>
						<img
							loading="lazy"
							class="product__photo-main"
							:src="require(`@/assets/img/products/${product.id}-1.png`)"
							:alt="product.name"
						/>
					</div>
					<div v-else>
						<swiper
							class="product__photo"
							:modules="[Thumbs]"
							watch-slides-progress
							@swiper="setThumbsSwiper"
							:loop="true"
							:allow-touch-move="false"
						>
							<swiper-slide
								class="product__photo-main"
								v-for="slide in product.images.split(',').length"
								:key="slide"
							>
								<img
									loading="lazy"
									@click="openLightboxOnSlide(slide)"
									:src="
										require(`@/assets/img/products/${product.id}-${slide}.png`)
									"
									:alt="product.name"
								/>
							</swiper-slide>
						</swiper>
						<div class="wrapper">
							<swiper
								:modules="[Thumbs, Navigation]"
								:navigation="{
									prevEl: '.swiper__prev',
									nextEl: '.swiper__next',
								}"
								:thumbs="{ swiper: thumbsSwiper }"
								:loop="true"
								:space-between="10"
								:slides-per-view="3"
								:watch-slides-progress="true"
								:slide-to-clicked-slide="true"
								:centered-slides="true"
							>
								<swiper-slide
									v-for="slide in product.images.split(',').length"
									:key="slide"
									class="product__photo-minor"
								>
									<img
										loading="lazy"
										:src="
											require(`@/assets/img/products/${product.id}-${slide}.png`)
										"
										:alt="product.name"
								/></swiper-slide>
							</swiper>
							<div
								class="material-symbols-outlined swiper__nav-el swiper__prev"
							>
								arrow_back_ios
							</div>
							<div
								class="material-symbols-outlined swiper__nav-el swiper__next"
							>
								arrow_forward_ios
							</div>
						</div>
					</div>
				</div>
				<div class="product__content">
					<h2 class="product__name">{{ product.name }}</h2>
					<span class="product__text">Price:</span>
					<div v-if="!product.promo" class="product__price">
						$ {{ product.price }}
					</div>
					<div v-else class="product__price">
						${{ product.promo }}
						<span class="product__price--reduced">${{ product.price }}</span>
					</div>
					<span class="product__text product__text--green flex-sp">
						<span
							class="material-symbols-outlined product__text product__text--green"
						>
							check
						</span>
						Availability: In Stock
					</span>
					<div class="quantity product__quantity">
						<button
							class="quantity__btn quantity__btn--left"
							@click="quantity == 0 ? 0 : quantity--"
						>
							-
						</button>
						<input
							type="number"
							v-model="quantity"
							min="1"
							class="quantity__input"
						/>
						<button
							class="quantity__btn quantity__btn--right"
							@click="quantity++"
						>
							+
						</button>
					</div>
					<GreenBtn class="product__buy" @click="addToBasket"
						>Add to cart</GreenBtn
					>
					<div class="payment-banner">
						<img
							loading="lazy"
							src="@/assets/img/payment.webp"
							alt="payment banner"
						/>
					</div>
					<ul>
						<li class="product__text product__text--li">
							Lorem ipsum dolor sit amet.
						</li>
						<li class="product__text product__text--li">
							Tempore reiciendis reprehenderit cum molestiae!
						</li>
						<li class="product__text product__text--li">
							Esse ipsum voluptates culpa voluptas!
						</li>
						<li class="product__text product__text--li">
							Velit expedita voluptatem repudiandae veniam!
						</li>
						<li class="product__text product__text--li">
							Fugit in voluptatem aperiam iure?
						</li>
					</ul>
				</div>
			</div>
			<div class="tabs">
				<div class="tabs__header">
					<div
						data-id="1"
						class="tabs__item tabs__item--active"
						@click="tabsHandler"
					>
						Description
					</div>
					<div data-id="2" class="tabs__item" @click="tabsHandler">
						Additional Info
					</div>
					<div data-id="3" class="tabs__item" @click="tabsHandler">Review</div>
				</div>
				<div class="tabs__body">
					<div data-id="1" class="tabs__content tabs__content--active">
						<p>
							Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean
							sollicitudin, lorem quis bibendum auctor, nisi elit consequat
							ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh
							vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit.
							Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non
							mauris vitae erat consequat auctor eu in elit. Class aptent taciti
							sociosqu ad litora torquent per conubia nostra. Version of Lorem
							Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean
							sollicitudin, lorem quis bibendum auctor, nisi elit consequat
							ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh
							vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit.
							Nam nec tellus a odio tincidunt auctor a ornare odio.
						</p>
						<ul>
							<li>Lorem ipsum dolor sit amet.</li>
							<li>Tempore reiciendis reprehenderit cum molestiae!</li>
							<li>Esse ipsum voluptates culpa voluptas!</li>
							<li>Velit expedita voluptatem repudiandae veniam!</li>
							<li>Fugit in voluptatem aperiam iure?</li>
							<li>Incidunt commodi minus ea! Ullam?</li>
							<li>Sed accusantium facere doloribus consequatur.</li>
							<li>Doloribus aut excepturi cum sapiente.</li>
							<li>Laborum tempora voluptate unde perferendis.</li>
							<li>Quasi ipsam quo minus delectus!</li>
						</ul>
					</div>
					<div data-id="2" class="tabs__content">
						<p>
							Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
							Nulla vitae elit libero, a pharetra augue. Cras justo odio,
							dapibus ac facilisis in, egestas eget quam. Donec sed odio dui.
							Donec sed odio dui.
						</p>
						<ul>
							<li>Lorem ipsum dolor sit amet.</li>
							<li>Veniam voluptatem sequi consequuntur in.</li>
							<li>Ut nihil ad nobis tempora?</li>
							<li>Sapiente, adipisci. Saepe, repudiandae molestiae.</li>
							<li>Eos ut cumque harum minus!</li>
						</ul>
					</div>
					<div data-id="3" class="tabs__content">
						<p>
							Duis sed odio sit amet nibh vulputate cursus a sit amet mauris.
							Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor
							a ornare odio. Sed non mauris vitae erat consequat auctor eu in
							elit. Class aptent taciti sociosqu ad litora torquent per conubia
							nostra, per inceptos himenaeos. Mauris in erat justo. Nullam ac
							urna eu felis dapibus condimentum sit amet a augue
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<NewsletterSection />
</template>

<style lang="scss">
.fslightbox-nav span {
	color: $color-white;
}

.preloader {
	background: #f8f5f0;

	img {
		width: 30%;
		object-fit: contain;
		margin: 0 auto;
		display: block;
	}
}

.tabs {
	&__header {
		display: flex;
		position: relative;

		&::after {
			content: '';
			position: absolute;
			height: 1px;
			width: 100%;
			background: rgba($color-pale-black, 0.5);
			bottom: 0px;
			z-index: -1;
		}
	}

	&__item {
		font-size: 18px;
		padding: 10px 15px;
		cursor: pointer;
		font-weight: 500;
		color: $color-pale-black;
		text-align: center;

		&--active {
			color: $color-black;
			font-weight: 500;
			border: 1px solid rgba($color-pale-black, 0.5);
			background: white;
			border-bottom-color: $color-white;
		}
	}

	&__content {
		display: none;
		padding-top: 30px;

		li,
		p {
			font-size: 16px;
			color: $color-pale-black;
			line-height: 1.5;
		}

		p,
		ul {
			margin-bottom: 15px;
		}

		li {
			margin-bottom: 5px;

			&::before {
				content: '';
				width: 5px;
				height: 5px;
				border-radius: 100%;
				display: inline-block;
				margin-right: 10px;
				transform: translateY(-50%);
				background-color: $color-main-green;
			}
		}

		&--active {
			display: block;
		}
	}
}

.quantity {
	width: 200px;
	height: 35px;

	border: 1px solid rgba($color-main-green, 0.2);
	border-radius: 5px;

	display: flex;

	&__btn {
		width: 20%;
		background: transparent;
		font-weight: 500;
		font-size: 14px;
		opacity: 0.85;

		&:hover {
			background-color: rgba($color-main-green, 0.12);
		}

		&--left {
			border-radius: 5px 0 0 5px;
		}

		&--right {
			border-radius: 0 5px 5px 0;
		}
	}

	&__input {
		-webkit-appearance: none;
		margin: 0;
		-moz-appearance: textfield;
		width: 60%;
		font-weight: 500;
		font-size: 14px;
		opacity: 0.85;
		text-align: center;
	}
}

@media screen and (min-width: $tablet) {
	.quantity {
		width: 250px;
	}
}

.product {
	&__container {
		margin-bottom: 90px;
	}

	&__text {
		display: block;
		font-size: 16px;
		color: $color-pale-black;
		line-height: 1.5;
		margin-bottom: 5px;

		&--green {
			color: $color-main-green;
		}

		&--li {
			&::before {
				content: '';
				width: 5px;
				height: 5px;
				border-radius: 100%;
				display: inline-block;
				margin-right: 10px;
				transform: translateY(-50%);
				background-color: $color-main-green;
			}
		}
	}
	&__header {
		padding-top: 50px;
		display: flex;
		flex-direction: column;
		gap: 50px;
		margin-bottom: 50px;
		align-items: center;
	}

	&__photo-wrapper {
		@include max-res-width(550px);
		@include px(28px);
	}

	&__photo-main,
	&__photo {
		width: 100%;
		cursor: pointer;

		img {
			width: 100%;
			object-fit: cover;
			transition: transform 0.3s ease-in-out;
		}

		overflow: hidden;

		&:hover {
			img {
				transform: scale(1.2);
			}
		}
	}

	&__photo-minor {
		cursor: pointer;
		img {
			width: 100%;
			object-fit: cover;
		}
	}

	&__content {
		@include max-res-width(600px);
	}

	&__name {
		text-transform: capitalize;
		font-weight: 500;
		font-size: 30px;
		line-height: 1.5;
		margin-bottom: 20px;
	}

	&__price {
		font-weight: 500;
		font-size: 22px;
		line-height: 1.5;
		letter-spacing: 0.13rem;
		color: $color-pale-black;
		margin-bottom: 20px;

		&--reduced {
			text-decoration: line-through;
			color: #df2437;
		}
	}

	&__quantity {
		margin-bottom: 22px;
	}

	&__buy {
		max-width: 200px;
		text-align: center;
		margin-bottom: 50px;
	}
}

@media screen and (min-width: $tablet) {
	.product {
		&__header {
			flex-direction: row;
			margin-bottom: 70px;
		}
		&__buy {
			max-width: 250px;
			text-align: center;
		}
	}
}

.wrapper {
	position: relative;
}

.swiper {
	&__nav-el {
		position: absolute;
		top: 50%;
		transform: translateY(-50%);
		cursor: pointer;
		font-size: 40px;
		@include py(10px);
		color: $color-main-green;
	}

	&__next {
		right: -40px;
	}
	&__prev {
		left: -30px;
	}
}

.flex-sp {
	display: flex;
	align-items: center;
	gap: 5px;
}

.payment-banner {
	@include max-res-width(500px);
	margin-bottom: 30px;
	img {
		width: 100%;
		object-fit: fill;
	}
}
</style>
