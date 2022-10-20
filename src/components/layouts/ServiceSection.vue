<script>
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
import { Splide, SplideSlide, SplideTrack } from '@splidejs/vue-splide';
import '@splidejs/vue-splide/css';

export default {
	data() {
		return {
			slides: [
				{
					id: 1,
					icon: 'delivery-man',
					title: 'Fasted delivery Service',
					description:
						'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
				},
				{
					id: 2,
					icon: 'shopping-list',
					title: 'Online order Service',
					description:
						'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
				},
				{
					id: 3,
					icon: 'fast-time',
					title: '24/8 Service',
					description:
						'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
				},
			],
		};
	},
	components: {
		SectionTitle,
		SectionDescription,
		Splide,
		SplideSlide,
		SplideTrack,
	},
	setup() {
		const options = {
			type: 'loop',
			perPage: 3,
			autoplay: true,
			interval: 4000,
			direction: 'ttb',
			height: '520px',
			width: '500px',
			focus: 'center',
			arrows: true,
			pagination: false,
			breakpoints: {
				846: {
					height: '350px',
					drag: false,
				},
			},
		};

		return { options };
	},
};
</script>

<template>
	<section class="service">
		<div class="container service__container">
			<div class="service__content">
				<SectionTitle class="service__title">What is Oars Store?</SectionTitle>
				<SectionDescription class="service__description">
					Lorem Ipsum is simply dummy text of the printing and typesetting
					industry. Lorem Ipsum has been the industry's standard dummy text ever
					since the 1500s, when an unknown printer took a galley...
				</SectionDescription>

				<Splide
					:has-track="false"
					class="splide service__splide"
					:options="options"
				>
					<SplideTrack>
						<SplideSlide
							v-for="slide in slides"
							:key="slide.id"
							class="splide-slide"
						>
							<div class="splide-slide__icon-wrapper">
								<svg :class="slide.icon" class="splide-slide__icon">
									<use
										:xlink:href="
											require('@/assets/files/sprite.svg') + '#' + slide.icon
										"
									></use>
								</svg>
							</div>
							<div class="splide-slide__text-content">
								<div class="splide-slide__title">{{ slide.title }}</div>
								<div class="splide-slide__discription">
									{{ slide.description }}
								</div>
							</div>
						</SplideSlide>
					</SplideTrack>
					<div class="splide__arrows">
						<button class="splide__arrow splide__arrow--prev"></button>
						<button class="splide__arrow splide__arrow--next">
							<svg class="svg-long-arrow-dims arrow-icon">
								<use
									class="svg-long-arrow-dims"
									xlink:href="@/assets/files/sprite.svg#long-arrow"
								></use>
							</svg>
						</button>
					</div>
				</Splide>
			</div>
			<div class="service__image-block image-with-courier">
				<div class="image-with-courier__green-elipse"></div>
				<img
					class="image-with-courier__green-snake"
					src="@/assets/img/snake-elipse.png"
					alt=""
				/>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
.service .svg-long-arrow-dims {
	width: 33px;
	height: 16px;
}

.image-with-courier {
	display: flex;
	max-width: 601px;
	padding: 20px;
	width: 100%;
	max-height: 601px;
	justify-content: center;
	align-items: center;
	position: relative;

	&:after {
		content: '';
		padding-top: 100%;
		display: block;
	}

	&__green-elipse {
		content: ' ';
		max-width: 420px;
		max-height: 456px;
		width: 100%;
		background-image: url('@/assets/img/kek.png');
		background-repeat: no-repeat;
		background-position: center;
		background-size: contain;

		&:after {
			content: '';
			padding-top: 109%;
			display: block;
		}
	}

	&__green-snake {
		display: none;
	}
}

@media screen and (min-width: 628px) {
	.image-with-courier {
		padding: 90px;

		&__green-elipse {
			position: absolute;
			top: 53px;
		}

		&__green-snake {
			width: 385px;
			display: block;
			position: absolute;
			right: 0;
			top: 0;
			animation: move-snake 5s linear infinite;
			transform-origin: 86.5px;
		}
	}
}

@media screen and (min-width: $desktop) {
	.image-with-courier {
		position: absolute;
		bottom: 70px;
		right: 0;
	}
}

@keyframes move-snake {
	0% {
		transform: rotate(0);
	}
	100% {
		transform: rotate(1turn);
	}
}

.service {
	&__container {
		position: relative;
		padding-top: 70px;
		padding-bottom: 70px;
		display: flex;
		flex-direction: column-reverse;
		align-items: center;
		margin: 0 auto;
	}

	&__image-block {
		margin-bottom: 56px;
	}

	&__title {
		margin-bottom: 20px;
		text-align: center;
	}
	&__description {
		display: block;
		margin-bottom: 56px;
		max-width: 637px;
	}

	&__content {
		display: flex;
		flex-direction: column;
		align-items: center;
	}
}

@media screen and (min-width: $tablet) {
	.service {
		&__container {
			padding-top: 140px;
			padding-bottom: 146px;
		}
	}
}

@media screen and (min-width: $desktop) {
	.service {
		&__container {
			flex-direction: row;
			justify-content: space-between;
		}

		&__image-block {
			align-self: flex-end;
			overflow: hidden;
			margin-bottom: 0;
		}

		&__content {
			display: block;
		}
	}
}
.service {
	.splide-slide {
		display: flex;
		align-items: center;
		padding: 20px;
		transition: all 0.3s;

		&__icon-wrapper {
			flex-shrink: 0;
			@include flex-center;
			@include wh(40px);
			border-radius: 50px;
			background-color: $color-light-green;
			margin-right: 14px;
			transition: all 0.3s;
		}

		&__title {
			font-weight: 700;
			font-size: 16px;
			line-height: 150%;
			margin-bottom: 8px;
		}

		&__description {
			font-weight: 400;
			font-size: 14px;
			line-height: 143%;
			color: $color-pale-black;
		}

		&__icon {
			@include wh(40px);
		}
	}

	.splide .is-active {
		background-color: $color-light-green;
		.splide-slide__icon-wrapper {
			background-color: #ffffff;
		}
	}
}

@media screen and (min-width: $tablet) {
	.service {
		.splide-slide {
			padding: 40px 59px;

			&__icon-wrapper {
				@include wh(80px);
				margin-right: 24px;
			}

			&__title {
				font-size: 20px;
				margin-bottom: 8px;
			}

			&__description {
				font-size: 12px;
			}
		}
	}
}

.service {
	.splide__arrow--prev {
		display: none;
	}

	.splide__arrow--next {
		bottom: -30px !important;
		max-width: 500px;
		border-radius: unset;
		width: 100%;
		min-height: 32px;
		display: flex;
		align-items: center;
		justify-content: center;
		cursor: pointer;
		background: transparent;

		.arrow-icon {
			fill: $color-main-green;
			transform: rotate(90deg);
		}

		& .arrow-icon {
			transform: rotate(90deg);
			animation: move 1.25s infinite;
		}
		&:hover .arrow-icon {
			animation-play-state: paused;
		}
	}
}

@keyframes move {
	0% {
		transform: translateY(0) rotate(90deg);
	}
	100% {
		transform: translateY(10px) rotate(90deg);
	}
}
</style>
