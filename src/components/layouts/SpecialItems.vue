<script>
import Parallax from 'parallax-js';
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
import ArrowBtn from '../ArrowBtn.vue';

export default {
	mounted() {
		const scene2 = document.getElementById('scene2');
		const scene3 = document.getElementById('scene3');
		new Parallax(scene2);
		new Parallax(scene3);
	},
	components: { SectionTitle, SectionDescription, ArrowBtn },
};
</script>

<template>
	<section class="special-items">
		<div class="container special-items__container">
			<div class="special-items__photo-wrapper" id="scene3">
				<div data-depth="0.3" class="layer">
					<img
						class="special-items__cucumber special-items__rotated-photo"
						src="@/assets/img/cucumber.png"
						alt="photo with cucumbers"
					/>
				</div>
				<div data-depth="0.24" class="layer">
					<img
						class="special-items__oranges special-items__rotated-photo"
						src="@/assets/img/oranges.png"
						alt="photo with oranges"
					/>
				</div>
				<div data-depth="0.18" class="layer">
					<img
						class="special-items__apples special-items__rotated-photo"
						src="@/assets/img/apples.png"
						alt="photo with apples"
					/>
				</div>
				<div data-depth="0.12" class="layer">
					<img
						class="special-items__greens special-items__rotated-photo"
						src="@/assets/img/green.png"
						alt="photo with greens"
					/>
				</div>
			</div>
			<div class="special-items__content">
				<SectionTitle class="special-items__title">
					Explore Our Shop
				</SectionTitle>
				<SectionDescription class="special-items__description">
					Lorem Ipsum is simply dummy text of the printing and typesetting
					industry. Lorem Ipsum has been the industry's standard dummy text ever
					since the 1500s, when an unknown printer...
				</SectionDescription>

				<ArrowBtn class="special-items__btn"> Explore Now </ArrowBtn>
			</div>
			<div id="scene2">
				<div data-depth="0.12" class="layer">
					<img
						class="special-items__paralax-img"
						src="@/assets/img/fresh-melientha-suavis-pierre-leaves-white-surface_removebg-preview.png"
						alt=""
					/>
				</div>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
.special-items {
	background-color: $color-light-green;

	&__container {
		padding-top: 89px;
		padding-bottom: 143px;
		display: flex;
		flex-direction: column;
		align-items: center;
		position: relative;
		overflow: hidden;
	}

	&__photo-wrapper {
		@include max-res-width(600px);
		max-height: 600px;
		background-color: $color-light-yellow;
		position: relative;
		overflow: hidden;
		margin-bottom: 50px;

		.layer {
			width: 100%;

			&:after {
				content: '';
				padding-top: 100%;
				display: block;
			}
		}
	}

	&__rotated-photo {
		position: absolute;
		width: 100%;
		box-shadow: 15px 15px 40px rgba($color-pale-yellow, 0.4);
		transform: rotate(30deg);
	}

	&__cucumber {
		z-index: 4;
		max-width: 41.67%;
		left: 13.64%;
		top: 12.43%;
	}

	&__oranges {
		z-index: 3;
		max-width: 33.33%;
		right: 0.03%;
		top: 10.57%;
	}

	&__apples {
		z-index: 2;
		max-width: 34.66%;
		left: 0.12%;
		top: 52.36%;
	}

	&__greens {
		z-index: 1;
		max-width: 44.95%;
		right: 9.7%;
		bottom: 12.21%;
	}

	&__content {
		position: relative;
		z-index: 1;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	&__title {
		text-align: center;
		margin-bottom: 20px;
	}

	&__description {
		max-width: 637px;
		margin-bottom: 50px;
	}

	#scene2 {
		align-self: flex-start;
		position: absolute;
		overflow: hidden;
		right: -100px;
		bottom: 0;
		z-index: 0;
	}

	&__paralax-img {
		overflow: hidden;
		width: 100%;
		max-width: 100%;
		opacity: 0.4;
	}

	&__btn {
		margin: 0 auto;
		margin-bottom: 10px;
	}
}

@media screen and (min-width: $desktop) {
	.special-items {
		&__container {
			flex-direction: row;
			align-items: stretch;
			justify-content: space-between;
			overflow: visible;
		}

		&__photo-wrapper {
			margin-right: 50px;
			margin-bottom: 0;
		}

		&__content {
			padding-top: 30px;
			align-items: flex-start;
		}

		&__title {
			text-align: start;
		}

		&__description {
			max-width: 574px;
		}

		&__btn {
			margin: 0;
		}

		&__paralax-img {
			opacity: 0.8;
		}
	}
}
</style>
