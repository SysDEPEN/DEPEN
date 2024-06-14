import { stepsProps } from "@/interfaces/stepsProps";

function classNames(...classes: any[]) {
  return classes.filter(Boolean).join(' ');
}

function StepComp({ steps }: { steps: stepsProps[] }) {
  return (
    <nav aria-label="Progress">
      <ol role="list" className="flex flex-col items-center">
        {/* Adicionando os rótulos acima das etapas */}
        <div className="flex justify-between w-full mb-4">
          {steps.map((step) => (
            <div key={step.id} className="flex-1 text-center">
              <span>{step.name}</span>
            </div>
          ))}
        </div>
        
        {/* Componente de passos */}
        <div className="flex items-center w-full">
          {steps.map((step, stepIdx) => (
            <li
              key={step.name}
              className={classNames(
                stepIdx !== steps.length - 1 ? "pr-8 sm:pr-20" : "",
                "relative"
              )}
            >
              {step.status === "complete" ? (
                <>
                  <div
                    className="absolute inset-0 flex items-center"
                    aria-hidden="true"
                  >
                    <div className="h-0.5 w-full bg-yellow-300" />
                  </div>
                  <a
                    className="relative flex h-10 w-10 items-center justify-center rounded-full bg-yellow-300 hover:bg-yellow-300"
                  >
                    <span className="text-white text-lg">{stepIdx + 1}</span>
                    <span className="sr-only">{step.name}</span>
                  </a>
                </>
              ) : step.status === "current" ? (
                <>
                  <div
                    className="absolute inset-0 flex items-center"
                    aria-hidden="true"
                  >
                    <div className="h-0.5 w-full bg-[#C9CFCC]" />
                  </div>
                  <a
                    className="relative flex h-10 w-10 items-center justify-center rounded-full border-2 border-[#C9CFCC] bg-[#C9CFCC]"
                    aria-current="step"
                  >
                    <span className="text-black font-bold">{stepIdx + 1}</span>
                    <span className="sr-only">{step.name}</span>
                  </a>
                </>
              ) : (
                <>
                  <div
                    className="absolute inset-0 flex items-center"
                    aria-hidden="true"
                  >
                    <div className="h-0.5 w-full bg-[#C9CFCC]" />
                  </div>
                  <a
                    className="group relative flex h-10 w-10 items-center justify-center rounded-full border-2 border-[#C9CFCC] bg-[#C9CFCC] hover:border-[#C9CFCC]"
                  >
                    <span className="text-black group-hover:text-gray-700 text-lg">
                      {stepIdx + 1}
                    </span>
                    <span className="sr-only">{step.name}</span>
                  </a>
                </>
              )}
            </li>
          ))}
        </div>
      </ol>
    </nav>
  );
}

export default StepComp;
