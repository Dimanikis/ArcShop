<script>
export default {
	data() {
		return {
			menu: [
				{
					link: '/',
					id: 1,
					name: 'home',
				},
				{
					link: '/store',
					id: 2,
					name: 'store',
				},
				{
					link: '/about-us',
					id: 3,
					name: 'about us',
				},
				{
					link: '/contact',
					id: 3,
					name: 'contact',
				},
			],
			mobile: false,
		};
	},

	methods: {
		toggleMobileMenu() {
			this.mobile = !this.mobile;
			document.body.classList.toggle('nonscroll');
		},
		closeMobileMenu() {
			this.mobile = false;
			document.body.classList.remove('nonscroll');
		},
	},
};
</script>

<template>
	<nav class="nav">
		<ul :class="{ 'nav__list--mobile': mobile }" class="nav__list">
			<li
				v-for="item in menu"
				:key="item.id"
				class="nav__item"
				@click="closeMobileMenu"
			>
				<router-link class="nav__link" :to="item.link">{{
					item.name
				}}</router-link>
			</li>
		</ul>
		<div class="site-overlay" @click="closeMobileMenu"></div>
		<div
			@click="toggleMobileMenu"
			class="burger nav__menu"
			:class="{ mobile: mobile }"
		>
			<div class="burger__item">
				<span></span>
			</div>
		</div>
	</nav>
</template>

<style lang="scss">
.site-overlay {
	content: '';
	position: fixed;
	width: 100vw;
	height: 100vh;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	z-index: 4;
	transition: all 0.4s ease-in-out;
	background-color: rgba(0, 0, 0, 0.5);
	opacity: 0;
	visibility: hidden;
}

.burger {
	display: block;
	position: relative;
	width: 24px;
	height: 16px;
	cursor: pointer;

	&::before,
	&::after {
		content: ' ';
		background-color: $color-main-green;
		position: absolute;
		width: 100%;
		height: 2px;
		left: 0;
		transition: all 0.4s ease;
	}

	&::before {
		top: 0;
	}

	&::after {
		bottom: 0;
	}

	& span {
		background-color: $color-main-green;
		position: absolute;
		width: 100%;
		height: 2px;
		left: 0;
		top: 7px;
		transition: all 0.3s ease;
	}

	&.mobile {
		z-index: 5;

		&::before {
			transform: rotate(45deg);
			top: 7px;
		}

		&::after {
			transform: rotate(-45deg);
			bottom: 7px;
		}

		& span {
			transform: scale(0);
		}
	}
}

@media screen and (min-width: $tablet) {
	.burger {
		display: none;
	}
}

.nav {
	&__list {
		display: flex;
		flex-direction: column;
		position: fixed;
		padding-top: 100px;
		max-width: 220px;
		top: 0;
		right: 0;
		bottom: 0;
		width: 100%;
		transform: translateX(100%);
		transition: transform 0.4s;
		background-color: #ffffff;
		&--mobile {
			transform: translateX(0);
			z-index: 5;
			& + .site-overlay {
				opacity: 1;
				visibility: visible;
			}
		}
	}

	.active {
		color: $color-main-green;
		text-shadow: 0 0 0.4px $color-main-green, 0 0 0.4px $color-main-green;
	}

	&__link {
		display: block;
		padding: 10px 40px;
		text-transform: capitalize;
		font-weight: 400;
		font-size: 16px;
		line-height: 1.5;
		transition: all 0.3s;
		position: relative;
	}
}

@media screen and (min-width: $tablet) {
	.nav {
		&__list {
			height: auto;
			position: unset;
			flex-direction: row;
			padding: 0;
			max-width: unset;
			width: auto;
			transform: translateX(0);
		}

		&__item {
			&:not(:last-child) {
				margin-right: 40px;
			}
		}

		&__link {
			padding: 0;
			font-size: 18px;

			&::after {
				position: absolute;
				content: '';
				width: 0%;
				height: 3px;
				background-color: $color-main-green;
				left: 50%;
				bottom: -5px;
				transition: all 0.3s ease-in-out;
			}
			&:hover::after {
				width: 100%;
				left: 0;
			}
		}
	}
}
</style>
