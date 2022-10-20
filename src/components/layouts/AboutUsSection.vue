<script>
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
export default {
	data() {
		return {
			dataList: [
				{
					id: 1,
					title: 'Natural Farm',
					description:
						'Lorem ipsum dolor sit amet consectetur adipiscing elit felis euismod sempe.',
				},
				{
					id: 2,
					title: 'Healthy Food',
					description:
						'Lorem ipsum dolor sit amet consectetur adipiscing elit felis euismod sempe.',
				},
				{
					id: 3,
					title: 'Biologically Safe',
					description:
						'Lorem ipsum dolor sit amet consectetur adipiscing elit felis euismod sempe.',
				},
				{
					id: 4,
					title: 'Biodiversity',
					description:
						'Lorem ipsum dolor sit amet consectetur adipiscing elit felis euismod sempe.',
				},
			],
		};
	},
	components: { SectionTitle, SectionDescription },
	mounted() {
		const items = document.querySelectorAll('.about-us-item');
		let delay = 50;

		items.forEach((el) => {
			el.dataset.aosDelay = delay;
			delay += 150;
		});
	},
};
</script>

<template>
	<section class="about-us">
		<div class="container about-us__container">
			<SectionTitle class="about-us__title">Who we are</SectionTitle>
			<SectionDescription class="about-us__description"
				>Cras mattis consectetur purus sit amet fermentum. Praesent commodo
				cursus magna, vel scelerisque nisl consectetur et.</SectionDescription
			>
			<div class="about-us__content">
				<div
					v-for="item in dataList"
					:key="item.id"
					class="about-us-item"
					data-aos="fade-up"
					data-aos-once="true"
				>
					<div class="about-us-item__photo">
						<img
							:src="require(`@/assets/img/about-${item.id}.png`)"
							:alt="item.title"
						/>
					</div>
					<span class="about-us-item__title">{{ item.title }}</span>
					<span class="about-us-item__description">{{ item.description }}</span>
				</div>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
.about-us {
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

	&__content {
		display: flex;
		flex-direction: column;
		align-items: center;
		gap: 50px;
	}
}

.about-us-item {
	@include max-res-width(285px);
	@include px(15px);
	display: flex;
	flex-direction: column;
	align-items: center;

	&__photo {
		width: 150px;
		margin-bottom: 28px;

		img {
			width: 100%;
			object-fit: fill;
		}
	}

	&__title {
		font-weight: 700;
		position: relative;
		padding-bottom: 12px;
		margin-bottom: 18px;
		font-size: 18px;

		&::before,
		&::after {
			position: absolute;
			content: '';
			left: 50%;
			top: 100%;
			height: 2px;
			background-color: $color-neon-green;
			transform: translate(-50%);
		}

		&::after {
			width: 2px;
			margin-left: 19px;
		}

		&::before {
			width: 31px;
		}
	}

	&__description {
		font-size: 14px;
		line-height: 1.5;
		text-align: center;
		color: $color-pale-black;
	}
}

@media screen and (min-width: 620px) {
	.about-us {
		&__content {
			max-width: 620px;
			flex-direction: row;
			justify-content: space-between;
			flex-wrap: wrap;
			gap: 50px;
			margin: 0 auto;
		}
	}

	.about-us-item {
		&__description {
			font-size: 16px;
			line-height: 2;
		}
	}
}

@media screen and (min-width: $desktop) {
	.about-us {
		&__content {
			max-width: 100%;
			flex-direction: row;
			flex-wrap: nowrap;
			gap: 40px;
			margin: 0 auto;
		}
	}
}
</style>
