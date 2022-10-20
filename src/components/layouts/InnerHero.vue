<script>
import SectionTitle from '../SectionTitle.vue';
export default {
	components: { SectionTitle },
	props: {
		title: String,
		gapLinks: [],
	},
};
</script>

<template>
	<section class="inner-hero">
		<div class="container inner-hero__container">
			<SectionTitle data-aos="zoom-in" class="inner-hero__title" :main="true">
				<slot />
			</SectionTitle>
			<nav data-aos="zoom-in" class="inner-nav">
				<router-link to="/" class="inner-nav__item">Home</router-link>
				<router-link
					v-for="link in gapLinks"
					:key="link.name"
					:to="link.link"
					class="inner-nav__item"
				>
					{{ link.name }}</router-link
				>
				<span class="inner-nav__item">{{ title }}</span>
			</nav>
		</div>
	</section>
</template>

<style lang="scss">
.inner-hero {
	background: $color-light-yellow;
	background-image: url('@/assets/img/testimonials-bg.webp');
	background-position: center;
	background-size: 100%;

	&__container {
		@include py(25px);
	}

	&__title {
		text-align: center;
		margin-bottom: 5px;
	}
}

@media screen and (min-width: $tablet) {
	.inner-hero {
		&__container {
			@include py(60px);
		}

		&__title {
			text-align: center;
			margin-bottom: 10px;
		}
	}
}

.inner-nav {
	display: flex;
	justify-content: center;

	&__item {
		font-size: 24px;
		font-weight: 500;
		text-transform: capitalize;
		font-family: 'Dancing Script', cursive;

		&:not(:last-child) {
			margin-right: 3px;
			transition: color 0.3s;

			&::after {
				margin-left: 3px;
				content: '/';
				font-size: 24px;
				font-weight: 500;
				font-family: 'Dancing Script', cursive;
			}

			&:hover {
				color: $color-main-green;
			}
		}
	}
}

@media screen and (min-width: $tablet) {
	.inner-nav {
		&__item {
			font-size: 30px;

			&:not(:last-child) {
				margin-right: 5px;

				&::after {
					margin-left: 5px;
					font-size: 30px;
				}
			}
		}
	}
}
</style>
