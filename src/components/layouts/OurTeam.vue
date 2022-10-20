<script>
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
import { Splide, SplideSlide, SplideTrack } from '@splidejs/vue-splide';
import '@splidejs/vue-splide/css';

export default {
	data() {
		return {
			team: [
				{
					id: 1,
					name: 'Karren Gillam',
					job: 'Senior UI/UX Designer',
					photo: 'avatar-3.webp',
				},
				{
					id: 2,
					name: 'Veronica Anluz',
					job: 'Smoothie Bartender',
					photo: 'avatar-1.webp',
				},
				{
					id: 3,
					name: 'Dominic Pursay',
					job: 'Developer',
					photo: 'avatar-4.webp',
				},
				{
					id: 4,
					name: 'Volodymyr Kholyavskiy',
					job: 'Lead Frontend Developer :)',
					photo: '1111.jpeg',
				},
				{
					id: 5,
					name: 'Jonny Miller',
					job: 'Senior UI/UX Designer',
					photo: 'avatar-2.webp',
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
			perPage: 4,
			perMove: 1,
			gap: '15px',
			autoplay: true,
			interval: 4000,
			arrows: true,
			pagination: false,
			breakpoints: {
				990: {
					perPage: 3,
				},
				610: {
					perPage: 2,
				},
				420: {
					perPage: 1,
				},
			},
		};

		return { options };
	},
};
</script>

<template>
	<section class="our-team">
		<div class="container our-team__container">
			<SectionTitle class="our-team__title">Meet Our Team</SectionTitle>
			<SectionDescription class="our-team__description"
				>Cras mattis consectetur purus sit amet fermentum. Praesent commodo
				cursus magna, vel scelerisque nisl consectetur et.</SectionDescription
			>
			<Splide
				:has-track="false"
				class="splide our-team__splide"
				:options="options"
			>
				<SplideTrack>
					<SplideSlide
						v-for="human in team"
						:key="human.id"
						class="splide-slide"
					>
						<div class="splide-slide__avatar">
							<img
								:src="require(`@/assets/img/${human.photo}`)"
								:alt="human.name"
							/>
						</div>
						<span class="splide-slide__name">{{ human.name }}</span>
						<span class="splide-slide__job">{{ human.job }}</span>
					</SplideSlide>
				</SplideTrack>
				<div class="splide__arrows">
					<button
						class="material-symbols-outlined splide__arrow splide__arrow--prev"
					>
						arrow_back_ios
					</button>
					<button
						class="material-symbols-outlined splide__arrow splide__arrow--next"
					>
						arrow_forward_ios
					</button>
				</div>
			</Splide>
		</div>
	</section>
</template>

<style lang="scss">
.our-team {
	background: $color-light-green;

	&__container {
		@include py(90px);
	}

	&__title {
		margin-bottom: 20px;
		text-align: center;
	}

	&__description {
		text-align: center;
		max-width: 637px;
		margin: 0 auto;
		margin-bottom: 50px;
	}
}

.our-team {
	.splide-slide {
		display: flex;
		flex-direction: column;
		align-items: center;

		&__avatar {
			border-radius: 50%;
			margin-bottom: 25px;
			@include wh(170px);

			img {
				width: 100%;
				border-radius: 50%;
				object-fit: fill;
			}
		}

		&__name {
			font-weight: 500;
			font-size: 18px;
			margin-bottom: 10px;
		}

		&__job {
			font-style: italic;
			font-weight: 400;
			margin-bottom: 10px;
			font-size: 14px;
			color: $color-main-green;
		}
	}

	.splide__arrow {
		border-radius: 0;
		@include button-style;
		font-size: 25px;
		@include flex-center;
		visibility: hidden;
		opacity: 0;

		&--next {
			right: 0;
		}

		&--prev {
			left: 0;
			padding-left: 5px;
		}
	}

	.splide:hover .splide__arrow {
		visibility: visible;
		opacity: 1;
	}
}
</style>
