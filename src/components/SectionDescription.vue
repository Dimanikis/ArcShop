<script>
export default {};
</script>

<template>
	<p class="section-description">
		<slot />
	</p>
</template>

<style lang="scss">
.section-description {
	font-weight: 400;
	font-size: 16px;
	line-height: 167%;
	color: $color-pale-black;
}

@media screen and (min-width: 846px) {
	.section-description {
		font-size: 18px;
	}
}
</style>
