<script>
export default {
	data() {
		return {
			showBtn: false,
		};
	},
	methods: {
		scrollToTop() {
			window.scrollTo(0, 0);
		},
		handleScroll() {
			if (window.scrollY >= 1000 || window.pageYOffset >= 1000) {
				this.showBtn = true;
			} else {
				this.showBtn = false;
			}
		},
	},
	mounted() {
		window.addEventListener('scroll', this.handleScroll);
	},
};
</script>

<template>
	<div class="go-top" :class="{ active: showBtn }" @click="scrollToTop">
		<img src="@/assets/img/totop.png" alt="gotop" />
		<span class="material-symbols-outlined"> keyboard_arrow_up </span>
	</div>
</template>

<style lang="scss">
.go-top {
	position: fixed;
	bottom: 30px;
	right: 30px;
	display: block;
	cursor: pointer;
	text-align: center;
	z-index: 2;
	opacity: 0;
	visibility: hidden;
	transition: all 0.3s;

	&.active {
		opacity: 1;
		visibility: visible;
	}

	.material-symbols-outlined {
		font-size: 60px;
		position: absolute;
		top: 0;
		left: 5px;
		color: $color-white;
	}
}
</style>
