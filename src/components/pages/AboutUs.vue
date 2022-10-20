<script>
import InnerHero from '../layouts/InnerHero.vue';
import NewsletterSection from '../layouts/NewsletterSection.vue';
import OurTeam from '../layouts/OurTeam.vue';
import ServiceSection from '../layouts/ServiceSection.vue';
import ProcessSection from '../layouts/ProcessSection.vue';
import AboutUsSection from '../layouts/AboutUsSection.vue';

export default {
	components: {
		InnerHero,
		NewsletterSection,
		OurTeam,
		ServiceSection,
		ProcessSection,
		AboutUsSection,
	},
};
</script>

<template>
	<InnerHero :title="'about us'"> About us </InnerHero>
	<AboutUsSection />
	<ServiceSection />
	<ProcessSection />
	<OurTeam />
	<NewsletterSection />
</template>

<style lang="scss"></style>
