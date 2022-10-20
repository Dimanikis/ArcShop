<script>
export default {};
</script>

<template>
	<router-link class="arrow-btn" to="store">
		<span class="arrow-btn__span">
			<slot />
		</span>
		<div class="arrow-btn__arrow-wrapper">
			<svg class="svg-long-arrow-dims arrow-btn__arrow">
				<use
					class="svg-long-arrow-dims"
					xlink:href="@/assets/files/sprite.svg#long-arrow"
				></use>
			</svg>
		</div>
	</router-link>
</template>

<style lang="scss">
.svg-long-arrow-dims {
	width: 33px;
	height: 16px;
}

.arrow-btn {
	@include flex-center;
	background: transparent;

	&__arrow-wrapper {
		animation: move-arrow-wrapper 1.5s infinite;
	}

	&__arrow {
		animation: move-arrow 1.5s infinite;
	}

	&:hover &__arrow-wrapper {
		animation-play-state: paused;
	}

	&:hover &__arrow {
		animation-play-state: paused;
	}

	&__span {
		display: block;
		font-weight: 500;
		font-size: 18px;
		line-height: 167%;
		margin-right: 20px;
	}

	&__arrow-wrapper {
		display: flex;
		align-items: center;
		justify-content: center;
		@include wh(50px);
		border-radius: 50px;
		background-color: $color-main-green;
	}

	&__arrow {
		fill: #ffffff;
		width: 26.4px;
		height: 12.8px;
	}
}

@keyframes move-arrow-wrapper {
	0% {
		transform: translate(0);
	}
	100% {
		transform: translate(20px);
	}
}
@keyframes move-arrow {
	0% {
		transform: translate(0);
	}
	100% {
		transform: translate(8px);
	}
}

@media screen and (min-width: $tablet) {
	.arrow-btn {
		&__span {
			font-size: 16px;
		}

		&__arrow-wrapper {
			width: 64px;
			height: 64px;
		}

		&__arrow {
			width: 33px;
			height: 16px;
		}
	}
}
</style>
