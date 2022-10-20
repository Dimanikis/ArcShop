<script>
import LogoItem from '../LogoItem.vue';
import SectionDescription from '../SectionDescription.vue';
export default {
	data() {
		return {
			navigation: [
				{
					id: 1,
					name: 'About us',
					link: '/about-us',
				},
				{
					id: 2,
					name: 'Store',
					link: '/store',
				},
				{
					id: 3,
					name: 'Contact',
					link: '/contact',
				},
			],
			resources: [
				{
					id: 1,
					name: 'Reviews',
					link: '#',
				},
				{
					id: 2,
					name: 'Blog',
					link: '#',
				},
				{
					id: 3,
					name: 'Update News',
					link: '#',
				},
			],
			smm: [
				{ id: 1, name: 'facebook', link: 'https://www.facebook.com/' },
				{ id: 1, name: 'twitter', link: 'https://twitter.com/' },
				{ id: 1, name: 'instagram', link: 'https://www.instagram.com/' },
			],
		};
	},
	components: { LogoItem, SectionDescription },
};
</script>

<template>
	<footer class="footer">
		<div class="container footer__container">
			<div class="footer__column logo-container">
				<LogoItem class="footer__logo" />
				<SectionDescription class="footer__description">
					Lorem Ipsum is simply dummy text of the printing and typesetting
					industry. Lorem Ipsum has been the industry's standard dummy text ever
					since the 1500s, when an unknown printer...
				</SectionDescription>
			</div>
			<div class="footer__column">
				<h3 class="footer__subtitle">Navigation</h3>
				<nav>
					<router-link
						class="footer__link"
						v-for="item in navigation"
						:key="item.id"
						:to="item.link"
						><p class="footer__link-text">{{ item.name }}</p></router-link
					>
				</nav>
			</div>
			<div class="footer__column">
				<h3 class="footer__subtitle">Resources</h3>
				<a
					class="footer__link"
					v-for="item in resources"
					:key="item.id"
					:href="item.link"
				>
					<p class="footer__link-text">{{ item.name }}</p>
				</a>
			</div>
			<div class="footer__column">
				<h3 class="footer__subtitle">Contact Us</h3>
				<a class="footer__link" href="mailto:oyasim@email.com">
					<span class="footer__link-text footer__email">
						Email: oyasim@email.com
					</span>
				</a>
				<div class="footer__smm">
					<a
						v-for="item in smm"
						:key="item.id"
						class="footer__icons-wrapper"
						:href="item.link"
					>
						<svg class="footer__icons">
							<use
								:xlink:href="
									require('@/assets/files/sprite.svg') + '#' + item.name
								"
							></use>
						</svg>
					</a>
				</div>
			</div>
		</div>
	</footer>
</template>

<style lang="scss">
.footer {
	&__container {
		padding-top: 90px;
		display: flex;
		flex-direction: column;
		align-items: center;
		padding-bottom: 90px;
	}

	&__column {
		display: flex;
		flex-direction: column;
		align-items: center;

		&:not(:last-child) {
			margin-bottom: 30px;
		}
	}

	&__logo {
		margin-bottom: 30px;
	}

	&__description {
		text-align: center;
		max-width: 345px;
	}

	&__subtitle {
		font-weight: 500;
		font-size: 24px;
		line-height: 31px;
		margin-bottom: 25px;
	}

	&__link {
		display: block;

		&:not(:last-child) {
			margin-bottom: 15px;
		}

		&:hover .footer__link-text {
			color: $color-main-green;
		}
	}

	&__email {
		margin-bottom: 15px;
	}

	&__link-text {
		text-align: center;
		font-weight: 400;
		font-size: 18px;
		line-height: 23px;
		color: $color-pale-black;
		transition: color 0.3s;
	}

	&__icons-wrapper {
		&:hover .footer__icons {
			fill: $color-main-green;
		}
		&:not(:last-child) {
			margin-right: 50px;
		}
	}

	&__icons {
		@include wh(25px);
		fill: $color-black;
		transition: fill 0.3s;
	}
}

@media screen and (min-width: 1280px) {
	.footer {
		&__container {
			padding-top: 140px;
			flex-direction: row;
			justify-content: flex-start;
			align-items: stretch;
		}

		&__column {
			display: block;

			&:not(:last-child) {
				margin-right: 130px;
				margin-bottom: 0;
			}

			&:first-of-type {
				margin-right: 90px;
			}
		}

		&__subtitle {
			padding-top: 45px;
		}

		&__description {
			text-align: start;
		}

		&__link {
			&:not(:last-child) {
				margin-bottom: 25px;
			}
		}

		&__email {
			margin-bottom: 25px;
		}

		&__link-text {
			text-align: start;
		}
	}
}

.logo-container {
	border: 5px solid $color-light-green;
	padding: 30px 30px 40px;
	position: relative;
	margin-bottom: 80px !important;

	&::after {
		background-image: url('@/assets/img/footer-bg2.png');
		content: '';
		position: absolute;
		bottom: 0;
		left: 0;
		right: 0;
		transform: translateY(50%);
		height: 105px;
		background-size: 75%;
		background-position: center right;
		background-repeat: no-repeat;
		z-index: 1;
	}
}

@media screen and (min-width: $desktop) {
	.logo-container {
		margin-bottom: 0 !important;
	}
}
</style>
