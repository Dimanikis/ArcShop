<script>
export default {
	data() {
		return {
			orderSteps: [
				{
					step: 1,
					description:
						'Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.',
				},
				{
					step: 2,
					description:
						'Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.',
				},
				{
					step: 3,
					description:
						'Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.',
				},
				{
					step: 4,
					description:
						'Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.',
				},
			],
		};
	},
	mounted() {
		const items = document.querySelectorAll('.step');
		let delay = 50;

		items.forEach((el) => {
			el.dataset.aosDelay = delay;
			delay += 150;
		});
	},
};
</script>

<template>
	<section class="process">
		<div
			v-for="step in orderSteps"
			:key="step.step"
			class="process__items step"
			:class="'step__' + step.step"
			data-aos="fade-up"
			data-aos-once="true"
		>
			<div class="step__img-wrapper">
				<img
					:src="require(`@/assets/img/step${step.step}-img.webp`)"
					:alt="'step' + step.step"
				/>
			</div>
			<h3 class="step__title">step {{ step.step }}.</h3>
			<p class="step__description">
				{{ step.description }}
			</p>
		</div>
	</section>
</template>

<style lang="scss">
.process {
	display: flex;
	flex-direction: column;
}

.step {
	padding: 90px 60px;
	background-repeat: no-repeat;
	background-size: auto;
	background-position: right bottom;
	display: flex;
	flex-direction: column;
	align-items: center;

	&__1 {
		background-color: $color-neon-green;
		background-image: url('@/assets/img/step1-bg.png');
	}

	&__2 {
		background-color: $color-pale-green;
		background-image: url('@/assets/img/step2-bg.png');
	}

	&__3 {
		background-color: $color-pale-yellow;
		background-image: url('@/assets/img/step3-bg.png');
	}

	&__4 {
		background-color: $color-pale-red;
		background-image: url('@/assets/img/step4-bg.png');
	}

	&__img-wrapper {
		@include wh(120px);
		margin-bottom: 35px;
		display: flex;
		align-items: flex-end;

		img {
			width: 100%;
			object-fit: cover;
		}
	}

	&__title {
		font-size: 24px;
		font-weight: 500;
		margin-bottom: 20px;
		text-transform: capitalize;
		color: white;
	}

	&__description {
		font-size: 14px;
		line-height: 1.5;
		text-transform: capitalize;
		color: white;
	}
}

@media screen and (min-width: 580px) {
	.process {
		flex-direction: row;
		flex-wrap: wrap;
	}

	.step {
		width: 50%;

		&__description {
			font-size: 16px;
		}
	}
}

@media screen and (min-width: $desktop) {
	.step {
		width: 25%;

		&__img-wrapper {
			@include wh(140px);
			margin-bottom: 40px;
		}

		&__title {
			font-size: 28px;
			margin-bottom: 25px;
		}

		&__description {
			font-size: 18px;
		}
	}
}
</style>
