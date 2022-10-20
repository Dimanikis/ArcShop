<script>
export default {
	data() {
		return {
			rotateRation: 0,
		};
	},
	props: {
		isMain: Boolean,
	},
	created() {
		window.addEventListener('scroll', this.handleScroll);
	},
	unmounted() {
		window.removeEventListener('scroll', this.handleScroll);
	},
	methods: {
		handleScroll() {
			const multiplier = 0.1;
			const logoAnimatedPart = document.querySelector('.logo__leaf');
			this.rotateRation = window.pageYOffset * multiplier;

			this.setRotate(logoAnimatedPart);
		},
		hoverScroll(event) {
			const logo = event.target.closest('.logo--main');
			if (logo) {
				this.rotateRation += 90;

				const logoAnimatedPart = logo.querySelector('.logo__leaf');

				this.setRotate(logoAnimatedPart);
			}
		},
		disableHoverScroll(event) {
			const logo = event.target.closest('.logo--main');
			if (logo) {
				this.rotateRation -= 90;

				const logoAnimatedPart = logo.querySelector('.logo__leaf');
				this.setRotate(logoAnimatedPart);
			}
		},
		setRotate(elemet) {
			elemet.style.transform = 'rotate(-' + this.rotateRation + 'deg)';
		},
	},
};
</script>

<template>
	<router-link
		to="/"
		class="logo"
		:class="[{ 'logo--main': isMain }]"
		@mouseover="hoverScroll"
		@mouseout="disableHoverScroll"
	>
		<svg class="svg-earth-dims logo__earth">
			<use xlink:href="../assets/files/sprite.svg#earth"></use>
		</svg>
		<svg class="svg-leaf-dims logo__leaf">
			<use xlink:href="../assets/files/sprite.svg#leaf"></use>
		</svg>
	</router-link>
</template>

<style lang="scss">
.logo {
	display: inline-block;
	width: calc(105px * 0.8);

	&__img {
		max-width: 100%;
		object-fit: cover;
	}
}

.svg-earth-dims {
	width: 36.76px;
	height: 36.86px;
}

.svg-leaf-dims {
	width: 55.97px;
	height: 56px;
}

.logo {
	display: block;
	width: 56px;
	height: 56px;
	padding: 13.79px 13.74px 5.35px 5.47px;
	position: relative;

	&__leaf {
		position: absolute;
		top: 0;
		right: 0;
		transition: all 0.3s;
		transform-origin: 23.5px 32px;
	}
}
</style>
