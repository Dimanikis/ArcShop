<script>
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
export default {
	components: { SectionTitle, SectionDescription },
	data() {
		return {
			tips: [
				{
					id: 1,
					summary: 'Get creative with courgettes',
					details:
						'Ut fermentum massa justo sit amet risus tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa. ',
				},
				{
					id: 2,
					summary: 'Italian style meatballs with courgette ‘tagliatelle’',
					details:
						'Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus. ',
				},
				{
					id: 3,
					summary: 'How to fillet round fish (mackerel, trout, etc.)',
					details:
						'Ut fermentum massa justo sit amet risus tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa. ',
				},
				{
					id: 4,
					summary: 'Irish fish chowder with soda bread',
					details:
						'Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus. ',
				},
				{
					id: 5,
					summary: 'Equipment you will need for this technique',
					details:
						'Ut fermentum massa justo sit amet risus tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa. ',
				},
			],
		};
	},
	methods: {
		toggleTabs(event) {
			const target = event.target;
			const accordionItem = target.closest(
				'.accordion__summary-wrapper'
			).parentNode;
			const listItems = document.querySelectorAll('.accordion__item');

			if (accordionItem.classList.contains('active')) {
				accordionItem.classList.remove('active');
				accordionItem.children[1].style.height = '0';
			} else {
				listItems.forEach((element) => {
					element.classList.remove('active');
					element.children[1].style.height = '0';
				});

				accordionItem.classList.add('active');
				accordionItem.children[1].style.height =
					accordionItem.children[1].children[0].offsetHeight + 'px';
			}
		},
	},
};
</script>

<template>
	<section class="we-are">
		<div class="container we-are__container">
			<div
				class="we-are__img"
				data-aos="fade-up"
				data-aos-delay="50"
				data-aos-offset="400"
				data-aos-once="true"
			>
				<img src="@/assets/img/man-with-milk.webp" alt="man with milk" />
			</div>
			<div class="we-are__content">
				<SectionTitle class="we-are__title">Why we are the best?</SectionTitle>
				<SectionDescription class="we-are__description">
					Cras mattis consectetur purus sit amet fermentum. Praesent vel
					scelerisque nisl consectetur et.</SectionDescription
				>
				<ul class="accordion we-are__accordion">
					<li class="accordion__item" v-for="tip in tips" :key="tip.id">
						<div class="accordion__summary-wrapper" @click="toggleTabs">
							<div class="accordion__icon icon">
								<span class="icon__item icon__left"></span>
								<span class="icon__item icon__right"></span>
							</div>
							<h3 class="accordion__summary">{{ tip.summary }}</h3>
						</div>
						<div class="accordion__details-wrapper">
							<p class="accordion__details">{{ tip.details }}</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
.we-are {
	background: $color-light-green;

	&__container {
		display: flex;
		flex-direction: column;
		padding-top: 45px;
	}

	&__img {
		@include max-res-width(630px);
		margin: 0 auto;
		margin-bottom: 50px;

		img {
			width: 100%;
			object-fit: cover;
		}
	}

	&__title {
		text-align: center;
	}

	&__description {
		max-width: 637px;
		text-align: center;
		margin: 0 auto;
		margin-bottom: 30px;
	}

	&__accordion {
		max-width: 600px;
		margin: 0 auto;
	}
}

@media screen and (min-width: $desktop) {
	.we-are {
		&__container {
			flex-direction: row;
			align-items: flex-start;
		}

		&__img {
			margin: 0;
			margin-right: 50px;
			align-self: flex-end;
		}

		&__content {
			padding-top: 60px;
		}

		&__title {
			text-align: start;
		}

		&__description {
			max-width: 637px;
			text-align: start;
			margin: 0;
			margin-bottom: 30px;
		}

		&__accordion {
			max-width: unset;
			margin: 0;
		}
	}
}

.icon {
	width: 12px;
	position: relative;

	&__item {
		position: absolute;
		top: 10%;
		display: block;
		content: '';
		width: 8px;
		height: 1px;
		background: $color-black;
		transition: transform 0.3s;
	}

	&__left {
		left: -5%;
		transform: rotate(45deg);
	}

	&__right {
		right: -5%;
		transform: rotate(-45deg);
	}
}

.accordion {
	position: relative;

	&::after {
		content: '';
		position: absolute;
		bottom: 0px;
		width: 100%;
		height: 1px;
		background: rgba($color-pale-black, 0.3);
	}

	&__summary-wrapper {
		display: flex;
		align-items: center;
		gap: 10px;
		padding: 15px 10px;

		border-bottom: 1px solid rgba($color-pale-black, 0.3);
		cursor: pointer;
	}

	&__summary-wrapper:hover &__summary {
		color: $color-main-green;
	}

	&__summary {
		font-size: 16px;
		font-weight: 500;
		line-height: 20px;
		transition: color 0.3s;
	}

	&__details-wrapper {
		height: 0;
		overflow: hidden;
		transition: all 0.4s linear;
	}

	&__details {
		@include py(15px);
		font-size: 14px;
		line-height: 1.5;
		color: $color-pale-black;

		border-bottom: 1px solid rgba($color-pale-black, 0.3);
	}
}

.active .accordion__summary {
	color: $color-main-green;
}

.active .icon__left {
	transform: rotate(-45deg);
}

.active .icon__right {
	transform: rotate(45deg);
}
</style>
