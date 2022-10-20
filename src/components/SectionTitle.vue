<script>
export default {
	props: {
		main: Boolean,
	},
};
</script>

<template>
	<h1 v-if="main" class="section-title section-title--main">
		<slot />
	</h1>
	<h2 v-else class="section-title">
		<slot />
	</h2>
</template>

<style lang="scss">
.section-title {
	font-family: 'Roboto', sans-serif;
	font-weight: 700;
	font-size: 34px;
	line-height: 129%;
}

@media screen and (min-width: $tablet) {
	.section-title {
		font-size: 50px;

		&--main {
			font-size: 60px;
		}
	}
}
</style>
