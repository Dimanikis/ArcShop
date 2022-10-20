<script>
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
export default {
	components: { SectionTitle, SectionDescription },
	data() {
		return {
			testimonials: [
				{
					id: 1,
					name: 'Rosinante Vole',
					job: 'Smoothie Bar',
					review:
						'Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus.',
				},
				{
					id: 2,
					name: 'Paul Walker',
					job: 'Smoothie Bar',
					review:
						'Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus.',
				},
				{
					id: 3,
					name: 'William Dogtooh',
					job: 'Farmer Store',
					review:
						'Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus.',
				},
				{
					id: 4,
					name: 'Zin’s Nguyen',
					job: 'Smoothie Bar',
					review:
						'Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus.',
				},
			],
		};
	},
};
</script>

<template>
	<section class="testimonials">
		<div class="container testimonials__container">
			<SectionTitle class="testimonials__title"
				>What Our Customer Saying?</SectionTitle
			>
			<SectionDescription class="testimonials__description"
				>Lorem Ipsum is simply dummy text of the printing and typesetting
				industry. Lorem Ipsum has been the industry's standard dummy text ever
				since the 1500s, when an unknown printer...
			</SectionDescription>
			<ul class="testimonials-list">
				<li
					class="testimonial"
					v-for="testimonial in testimonials"
					:key="testimonial.id"
					data-aos="fade-up"
				>
					<div class="testimonial__photo">
						<img
							:src="require(`@/assets/img/testimonial-${testimonial.id}.webp`)"
							:alt="testimonial.name"
						/>
					</div>
					<div class="testimonial__content">
						<p class="testimonial__review">
							{{ testimonial.review }}
						</p>
						<span class="testimonial__name">
							{{ testimonial.name }}
						</span>
						<span class="testimonial__job">
							{{ testimonial.job }}
						</span>
					</div>
				</li>
			</ul>
		</div>
	</section>
</template>

<style lang="scss">
.testimonials {
	background: $color-light-yellow;
	background-image: url('@/assets/img/testimonials-bg.webp');
	background-repeat: repeat-y;
	background-position: center top;
	background-size: 100%;

	&__container {
		padding-top: 90px;
		padding-bottom: 140px;
	}

	&__title {
		text-align: center;
		margin-bottom: 20px;
	}

	&__description {
		max-width: 637px;
		margin: 0 auto;
		text-align: center;
		margin-bottom: 35px;
	}
}

@media screen and (min-width: $desktop) {
	.testimonials {
		&__title {
			margin-bottom: 30px;
		}

		&__description {
			margin-bottom: 50px;
		}
	}
}

.testimonials-list {
	width: 100%;
	margin: 0 auto;
}

@media screen and (min-width: 450px) {
	.testimonials-list {
		max-width: 630px;
	}
}

@media screen and (min-width: $desktop) {
	.testimonials-list {
		max-width: 100%;
		display: flex;
		justify-content: space-between;
		flex-wrap: wrap;
		gap: 30px;
	}
}

.testimonial {
	display: flex;
	flex-direction: column;
	background: white;
	box-shadow: 0px 15px 25px rgba($color-pale-yellow, 0.2);
	padding-top: 20px;
	padding-bottom: 20px;

	&:not(:last-child) {
		margin-bottom: 30px;
	}

	&__photo {
		margin: 0 auto;
		margin-bottom: 30px;
	}

	&__content {
		padding: 10px 30px;
	}

	&__review {
		font-size: 14px;
		font-style: italic;
		line-height: 1.7em;
		margin-bottom: 10px;
		color: $color-pale-black;
	}

	&__name {
		display: block;
		font-size: 14px;
		font-weight: 500;
		margin-bottom: 5px;
	}

	&__job {
		font-size: 12px;
		color: $color-main-green;
	}
}

@media screen and (min-width: 450px) {
	.testimonial {
		flex-direction: row;
		align-items: center;
		padding-left: 20px;

		&__photo {
			margin-bottom: 0;
			margin-right: 30px;
		}

		&__content {
			padding: 20px;
		}

		&__review {
			font-size: 16px;
			line-height: 1.7em;
			margin-bottom: 15px;
		}

		&__name {
			font-size: 16px;
			margin-bottom: 10px;
		}

		&__job {
			font-size: 14px;
		}
	}
}

@media screen and (min-width: $desktop) {
	.testimonial {
		width: calc(100% / 2 - 15px);

		&:not(:last-child) {
			margin-bottom: 0;
		}

		&__review {
			font-size: 18px;
		}
	}
}
</style>
