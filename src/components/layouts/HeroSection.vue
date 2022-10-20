<script>
import Parallax from 'parallax-js';
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
import ArrowBtn from '../ArrowBtn.vue';

export default {
	methods: {
		counter(element, max, interval = 100) {
			let counter = 0;
			let countFunction = setInterval(function () {
				max > 100 ? (counter += 10) : (counter += 2);
				element.textContent = counter;

				if (counter == max * 0.8) {
					clearInterval(countFunction);

					let slowerCountFunction = setInterval(function () {
						max > 100 ? (counter += 5) : counter++;
						element.textContent = counter;

						if (counter >= max) {
							clearInterval(slowerCountFunction);
						}
					}, interval * 2);
				}
			}, interval);
		},
	},

	mounted() {
		//add parallax effects
		const scene = document.getElementById('scene');
		new Parallax(scene);

		const counters = document.querySelectorAll('.hero__counter-item');
		const reviewItems = document.querySelectorAll('.hero__review-item');

		reviewItems.forEach((element) => {
			element.classList.add('not-opacity');
		});

		counters.forEach((element) => {
			if (element.classList.contains('order-user')) {
				this.counter(element, 30);
			}
			if (element.classList.contains('reviews')) {
				this.counter(element, 20);
			}
			if (element.classList.contains('items')) {
				this.counter(element, 300, 50);
			}
		});
	},
	components: { SectionTitle, SectionDescription, ArrowBtn },
};
</script>

<template>
	<section class="hero">
		<div class="container hero__container">
			<div id="scene">
				<div data-depth="0.12" class="layer">
					<img
						class="hero__paralax-img"
						src="@/assets/img/fresh-melientha-suavis-pierre-leaves-white-surface_removebg-preview.png"
						alt="image with leaves"
					/>
				</div>
			</div>
			<div class="hero__title-wrapper">
				<SectionTitle data-aos="zoom-in" class="hero__title" :main="true"
					>Organic & Healty Food</SectionTitle
				>
				<SectionDescription data-aos="zoom-in" class="hero__description">
					Lorem Ipsum is simply dummy text of the printing and typesetting
					industry. Lorem Ipsum has been the industry's standard dummy text ever
					since the 1500s, when an unknown printer took a
					galley...</SectionDescription
				>
			</div>
			<ArrowBtn class="hero__btn">Order Now</ArrowBtn>
			<div class="hero__photo-and-reviews">
				<div class="hero__image-wrapper">
					<img
						class="hero__image"
						src="@/assets/img/vegetables-fruits-white.png"
						alt="vegetables and fruits"
					/>
				</div>
				<div class="hero__reviews">
					<div class="hero__review-item">
						<div class="hero__icon-wrapper">
							<svg class="svg-user-dims hero__icon">
								<use
									xlink:href="@/assets/files/sprite.svg#user"
									class="svg-user-dims"
								></use>
							</svg>
						</div>
						<div class="hero__counter-wrapper">
							<div class="hero__counter">
								<span class="hero__counter-item order-user">30</span>K
							</div>
							<div class="hero__counter-description">User Order</div>
						</div>
					</div>
					<div class="hero__review-item">
						<div class="hero__icon-wrapper">
							<svg class="svg-star-weird-dims hero__icon">
								<use
									xlink:href="@/assets/files/sprite.svg#star-weird"
									class="svg-user-dims"
								></use>
							</svg>
						</div>
						<div class="hero__counter-wrapper">
							<div class="hero__counter">
								<span class="hero__counter-item reviews">20</span>K
							</div>
							<div class="hero__counter-description">Reviews(4.8)</div>
						</div>
					</div>
					<div class="hero__review-item">
						<div class="hero__icon-wrapper">
							<svg class="svg-harvest-dims hero__icon">
								<use
									xlink:href="@/assets/files/sprite.svg#harvest"
									class="svg-user-dims"
								></use>
							</svg>
						</div>
						<div class="hero__counter-wrapper">
							<div class="hero__counter">
								<span class="hero__counter-item items">300</span>
							</div>
							<div class="hero__counter-description">Items</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
#scene {
	position: absolute;
	z-index: 2;
	top: -37px;
	left: 0;
	width: 100%;
	max-width: 100%;
	overflow: hidden;
}

.hero {
	background-color: $color-light-green;

	&__container {
		position: relative;
		@include py(50px);
	}

	&__paralax-img {
		opacity: 0.4;
	}

	&__title-wrapper {
		display: flex;
		flex-direction: column;
		align-items: center;
		position: relative;
		z-index: 2;
	}

	&__title {
		text-align: center;
		margin-bottom: 20px;
	}

	&__description {
		display: block;
		max-width: 637px;
		text-align: center;
		margin-bottom: 40px;
	}

	&__photo-and-reviews {
		display: flex;
		flex-direction: column;
	}

	&__reviews {
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	&__review-item {
		display: flex;
		align-items: center;
		padding: 10px 16px;
		background-color: #ffffff;
		border-radius: 8px;
		box-shadow: -15px 15px 25px rgba(0, 96, 60, 0.04);
		opacity: 0;
		transition: all 1.5s;

		&:not(:last-child) {
			margin-bottom: 30px;
		}

		&.not-opacity {
			opacity: 1;
		}
	}

	&__icon-wrapper {
		@include wh(56px);
		border-radius: 50px;
		display: flex;
		align-items: center;
		justify-content: center;
		background-color: $color-light-green;
		margin-right: 24px;
	}

	&__counter-wrapper {
		display: flex;
		align-items: center;
		flex-direction: column;
	}

	&__counter {
		text-align: center;
		font-weight: 400;
		font-size: 38px;
		line-height: 100%;
		min-width: 95px;
	}

	&__counter-description {
		text-align: center;
		font-weight: 400;
		font-size: 16px;
		line-height: 167%;
		padding-top: 4px;
	}

	&__image-wrapper {
		position: relative;
		margin-bottom: 10px;
	}

	&__image {
		@include max-res-width(862px);
		object-fit: cover;
	}

	&__btn {
		margin: 0 auto;
		position: relative;
		z-index: 2;
		margin-bottom: 10px;
	}

	&__icon {
		@include wh(32px);
	}
}

@media screen and (min-width: 446px) {
	.hero {
		&__photo-and-reviews {
			position: relative;
			display: flex;
			flex-direction: row;
			justify-content: flex-end;
		}

		&__image-wrapper {
			position: absolute;
			top: 0;
			left: 0;
			z-index: 0;
		}

		&__reviews {
			z-index: 2;
			align-items: flex-end;
			padding-right: 20px;
		}
	}
}

@media screen and (min-width: $tablet) {
	.hero {
		&__container {
			padding-top: 92px;
		}

		&__photo-and-reviews {
			position: relative;
			flex-direction: row;
		}

		&__image-wrapper {
			margin-bottom: 0;
			top: unset;
			left: 20px;
			bottom: -17px;
		}

		&__reviews {
			align-items: flex-end;
		}

		&__review-item {
			max-width: 250px;
			padding: 17px 33px;
		}

		&__counter {
			font-size: 48px;
		}

		&__btn {
			margin-bottom: 0;
		}
	}
}

@media screen and (min-width: $desktop) {
	.hero {
		&__photo-and-reviews {
			padding-right: 0;
		}

		&__paralax-img {
			opacity: 0.8;
		}
	}
}
</style>
