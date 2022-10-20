<script>
import { defineComponent } from 'vue';
import { GoogleMap, Marker } from 'vue3-google-map';

export default defineComponent({
	components: { GoogleMap, Marker },
	setup() {
		const center = { lat: 46.48811798529199, lng: 30.74121463237711 };

		const image = require('@/assets/img/el-gr.png');

		return { center, image };
	},
});
</script>

<template>
	<GoogleMap
		api-key="AIzaSyBVA1qnUDoxVqoT6foVbBmE-uHKQ64P3Bk"
		style="width: 100%; height: 500px"
		:center="center"
		:zoom="15"
		:disable-default-ui="true"
	>
		<Marker
			:options="{ position: center, title: 'We are here!', icon: image }"
		/>
	</GoogleMap>
</template>

<style lang="scss">
@keyframes pulse-map {
	0% {
		box-shadow: 0 0 0 0 rgba($color-white, 0.8),
			0 0 0 25px rgba($color-white, 0);
	}

	50% {
		box-shadow: 0 0 0 25px rgba($color-white, 0.8),
			0 0 0 25px rgba($color-white, 0);
	}

	65% {
		box-shadow: 0 0 0 25px rgba($color-white, 0.8),
			0 0 0 50px rgba($color-white, 0.3);
	}

	100% {
		box-shadow: 0 0 0 0 rgba($color-white, 0.8), 0 0 0 0 rgba($color-white, 0);
	}
}

[aria-label='We are here!'] {
	animation: pulse-map 1.4s linear infinite;
	border-radius: 50%;
}
</style>
